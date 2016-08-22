package org.nemanjamarjanovic.rekomendator.presentation.temp;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MoviesDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Genre;

/**
 *
 * @author nemanja.marjanovic
 */
public class MovieContext
{

    @Inject
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
