package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

}
