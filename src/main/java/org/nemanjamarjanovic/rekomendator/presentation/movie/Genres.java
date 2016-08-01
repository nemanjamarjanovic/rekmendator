package org.nemanjamarjanovic.rekomendator.presentation.movie;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@RequestScoped
public class Genres implements Serializable
{

    private List<Genre> all;

    public List<Genre> getAll()
    {
        return all;
    }

    public void setAll(List<Genre> all)
    {
        this.all = all;
    }

}
