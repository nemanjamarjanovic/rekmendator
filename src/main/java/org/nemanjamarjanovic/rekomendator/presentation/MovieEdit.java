package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.actorclient.control.ActorService_Service;
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
    
    ActorService_Service actorService_Service = new ActorService_Service();

    private Movie data = new Movie();
    private List<String> actors = new ArrayList<>();

    public String doCreate() {
        Movie createMovie = moviesDao.createMovie(data, actors);
        return "movie-view?faces-redirect=true&id=" + createMovie.getId();
    }

    public String doUpdate() {
        moviesDao.updateMovie(data, actors);
        return "movie-view?faces-redirect=true&id=" + data.getId();
    }

    public void doAddActor(String actor) {
         String search = actorService_Service.getActorServicePort().search(actor);
        this.actors.add(search);
    }

    public Movie getData() {
        return data;
    }

    public void setData(Movie data) {
        this.data = data;
    }

    public List<String> getActors() {
        return actors;
    }

}
