package org.nemanjamarjanovic.rekomendator.presentation;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MovieDao;

/**
 *
 * @author nemanja
 */
@Model
public class MovieAction {

    @Inject
    private MovieDao moviesDao;
    
    @Inject
    private CurrentUser currentUser;
    
    public String doFavorite(String movie) {
        moviesDao.addToFavorites(movie, currentUser.getId());
        return "movie-view?faces-redirect=true&id="+movie;
    }

//    @Inject
//    public String doRate(String movie) {
//        //moviesDao.updateMovie(data);
//        return "movie-view?faces-redirect=true";
//    }
}
