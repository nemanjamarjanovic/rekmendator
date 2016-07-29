package org.nemanjamarjanovic.rekomendator.presentation.movie;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.MoviesDao;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@ConversationScoped
public class MovieContext implements Serializable
{

//    @Inject
//    Conversation conversation;

    @Inject
    private Movies movies;

    @Inject
    private Actors actors;

    @Inject
    private Genres genres;

    @EJB
    MoviesDao moviesDao;

    @PostConstruct
    public void init()
    {
        //conversation.begin();
        movies.setAll(moviesDao.findAllMovies());
        actors.setAll(moviesDao.findAllActors());
        genres.setAll(moviesDao.findAllGenres());
    }

//    public void end()
//    {
//        conversation.end();
//    }

}
