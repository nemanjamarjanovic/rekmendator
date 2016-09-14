package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.actor.boundary.ActorServiceClient;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.MovieDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class MovieEdit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private MovieDao moviesDao;
    
    @Inject 
    ActorServiceClient actorServiceClient;


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
        String search = actorServiceClient.search(actor);
        if(search == null){
            actorServiceClient.add(actor);
            search = actor;
        }
        this.actors.add(search);
    }

    public void doRemoveActor(String actor) {
        
        if (this.actors.contains(actor)) {
            this.actors.remove(actor);
        }
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
