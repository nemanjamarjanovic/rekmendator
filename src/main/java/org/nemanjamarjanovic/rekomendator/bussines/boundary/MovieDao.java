package org.nemanjamarjanovic.rekomendator.bussines.boundary;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Favorite;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Movie;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja
 */
@Stateless
public class MovieDao {

    @PersistenceContext
    EntityManager entityManager;

    public Movie findMovieById(String id) {
        return entityManager.find(Movie.class, id);
    }

    public Genre findGenreById(String id) {
        return entityManager.find(Genre.class, id);
    }

    public Actor findActorById(String id) {
        return entityManager.find(Actor.class, id);
    }

    public List<Movie> findAllMovies() {
        return entityManager
                .createNamedQuery(Movie.FIND_ALL, Movie.class)
                .getResultList();
    }

    public List<Movie> searchMovies(String title) {
        return entityManager
                .createNamedQuery(Movie.FIND_BY_TITLE, Movie.class)
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }

    public List<Genre> findAllGenres() {
        return entityManager
                .createNamedQuery(Genre.FIND_ALL, Genre.class)
                .getResultList();
    }

    public List<Actor> findAllActors() {
        return entityManager
                .createNamedQuery(Actor.FIND_ALL, Actor.class)
                .getResultList();
    }

    public void createMovie(final Movie data) {

        Movie movie = new Movie();
        movie.setId(UUID.randomUUID().toString());
        movie.setTitle(data.getTitle());
        movie.setDuration(data.getDuration());
        movie.setDescription(data.getDescription());
        movie.setPublishingDate(data.getPublishingDate());

        movie.setGenre(new HashSet<>(10));
        data.getGenre().stream().map(g -> entityManager
                .getReference(Genre.class, g.getTitle()))
                .forEach(g -> movie.getGenre().add(g));

        movie.setActors(new HashSet<>(10));
        data.getActors().stream().map(a -> entityManager
                .getReference(Actor.class, a.getId()))
                .forEach(a -> movie.getActors().add(a));

        entityManager.persist(movie);
    }

    public void updateMovie(final Movie data) {

        Movie movie = entityManager.find(Movie.class, data.getId());

        movie.setTitle(data.getTitle());
        movie.setDuration(data.getDuration());
        movie.setDescription(data.getDescription());
        movie.setPublishingDate(data.getPublishingDate());

        movie.setGenre(new HashSet<>(10));
        data.getGenre().stream().map(g -> entityManager
                .getReference(Genre.class, g.getTitle()))
                .forEach(g -> movie.getGenre().add(g));

        movie.setActors(new HashSet<>(10));
        data.getActors().stream().map(a -> entityManager
                .getReference(Actor.class, a.getId()))
                .forEach(a -> movie.getActors().add(a));

        entityManager.persist(movie);
    }

    public Genre createGenre(String title) {
        Genre genre = new Genre(title);
        entityManager.persist(genre);
        return genre;
    }

    public Actor createActor(String title) {
        Actor actor = new Actor(title);
        entityManager.persist(actor);
        return actor;
    }

    public void addToFavorites(String movie, String user) {
        Favorite favorite = new Favorite();
        favorite.setId(UUID.randomUUID().toString());
        favorite.setCreatedDate(new Date());
        favorite.setUser(entityManager.getReference(User.class, user));
        favorite.setMovie(entityManager.getReference(Movie.class, movie));
        entityManager.persist(favorite);
    }

}
