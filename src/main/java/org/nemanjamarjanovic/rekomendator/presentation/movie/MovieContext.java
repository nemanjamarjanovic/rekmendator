package org.nemanjamarjanovic.rekomendator.presentation.movie;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.MoviesDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;

/**
 *
 * @author nemanja.marjanovic
 */
public class MovieContext
{

    @EJB
    MoviesDao moviesDao;

    @Produces
    @Named
    public List<Genre> getAllGenres()
    {
        return moviesDao.findAllGenres();
    }

    @Produces
    @Named
    public List<Actor> getAllActors()
    {
        return moviesDao.findAllActors();
    }

}
