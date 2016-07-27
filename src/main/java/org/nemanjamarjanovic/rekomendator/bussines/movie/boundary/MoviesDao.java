package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja
 */
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
}
