package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.FavoriteDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.MovieDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

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
        Movie createMovie = moviesDao.createMovie(data);
        return "movie-view?faces-redirect=true&id=" + createMovie.getId();
    }

    public String doUpdate() {
        moviesDao.updateMovie(data);
        return "movie-view?faces-redirect=true&id=" + data.getId();
    }

    public Movie getData() {
        return data;
    }

    public void setData(Movie data) {
        this.data = data;
    }

}
