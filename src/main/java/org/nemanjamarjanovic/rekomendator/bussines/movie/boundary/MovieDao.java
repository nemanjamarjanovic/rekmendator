package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja
 */
@Stateless
@Loggable
public class MovieDao {

    @PersistenceContext
    EntityManager entityManager;

    public Movie findById(String id) {
        return entityManager.find(Movie.class, id);
    }

    public List<Movie> findAll() {
        return entityManager
                .createNamedQuery(Movie.FIND_ALL, Movie.class)
                .getResultList();
    }

    public List<Movie> search(String title, Date publishingDate, List<Genre> genres) {

        String titleParam = (title == null) ? null : "%" + title.trim() + "%";

        return entityManager
                .createNamedQuery(Movie.SEARCH, Movie.class)
                .setParameter("title", titleParam)
                // .setParameter("publishingDate", publishingDate)
                .getResultList();
    }

    public Movie createMovie(final Movie data, List<String> actors) {

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
        actors.stream().map(a -> entityManager
                .getReference(Actor.class, a))
                .forEach(a -> movie.getActors().add(a));

        entityManager.persist(movie);

        return movie;
    }

    public Movie updateMovie(final Movie data, List<String> actors) {

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
        actors.stream().map(a -> entityManager
                .getReference(Actor.class, a))
                .forEach(a -> movie.getActors().add(a));

        return movie;
    }

}
