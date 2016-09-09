package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.FavoriteDao;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MovieDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Movie;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class MovieEdit implements Serializable {

    @Inject
    private MovieDao moviesDao;
    
    @Inject
    private FavoriteDao favoriteDao;
    
    @Inject
    private CurrentUser currentUser;

    private Movie data = new Movie();

    public String doCreate() {
        moviesDao.createMovie(data);
        return "movie-list?faces-redirect=true";
    }

    public String doUpdate() {
        moviesDao.updateMovie(data);
        return "movie-list?faces-redirect=true";
    }

    public Movie getData() {
        return data;
    }

    public void setData(Movie data) {
        this.data = data;
    }

    
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
