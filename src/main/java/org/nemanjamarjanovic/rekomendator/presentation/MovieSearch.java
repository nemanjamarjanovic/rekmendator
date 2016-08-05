package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.MoviesDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@ViewScoped
public class MovieSearch implements Serializable
{

    @EJB
    MoviesDao moviesDao;

    private String title = "";
    private List<Movie> result = new ArrayList<>();

    public void doSearch()
    {
        if (title.length() > 2) {
            result = moviesDao.searchMovies(title);
        }
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<Movie> getResult()
    {
        return result;
    }

    public void setResult(List<Movie> result)
    {
        this.result = result;
    }

}
