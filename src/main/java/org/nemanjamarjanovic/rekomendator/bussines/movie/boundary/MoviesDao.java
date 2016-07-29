package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja
 */
@Stateless
public class MoviesDao
{

    @PersistenceContext
    EntityManager entityManager;

    public List<Movie> findAllMovies()
    {
        return entityManager.createNamedQuery(Movie.FIND_ALL, Movie.class).getResultList();
    }

    public List<Genre> findAllGenres()
    {
        return entityManager.createNamedQuery(Genre.FIND_ALL, Genre.class).getResultList();
    }

    public List<Actor> findAllActors()
    {
        return entityManager.createNamedQuery(Actor.FIND_ALL, Actor.class).getResultList();
    }

    public void createMovie(String title, Set<Genre> genres, Set<Actor> actors)
    {

        Movie movie = new Movie();
        movie.setId(UUID.randomUUID());
        movie.setTitle(title);

        movie.setGenre(new HashSet<>(10));
        genres.stream().map(g -> entityManager.getReference(Genre.class, g.getTitle())).forEach(g -> movie.getGenre().add(g));

        movie.setActors(new HashSet<>(10));
        actors.stream().map(a -> entityManager.getReference(Actor.class, a.getId())).forEach(a -> movie.getActors().add(a));

        entityManager.persist(movie);
    }

    public Genre createGenre(String title)
    {
        Genre genre = new Genre(title);
        entityManager.persist(genre);
        return genre;
    }

    public Actor createActor(String title)
    {
        Actor actor = new Actor(title);
        entityManager.persist(actor);
        return actor;
    }
}
