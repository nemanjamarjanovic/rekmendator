package org.nemanjamarjanovic.rekomendator.presentation.movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@Dependent
public class Movies implements Serializable
{

    private List<Movie> all = new ArrayList<>();

    public List<Movie> getAll()
    {
        return all;
    }

    public void setAll(List<Movie> all)
    {
        this.all = all;
    }

}
