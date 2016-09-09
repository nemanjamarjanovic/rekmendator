package org.nemanjamarjanovic.rekomendator.presentation.temp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MovieDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Movie;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@ViewScoped
public class MovieSearch implements Serializable
{

    @Inject
    MovieDao moviesDao;

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
