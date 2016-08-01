package org.nemanjamarjanovic.rekomendator.presentation.movie;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@RequestScoped
public class Actors implements Serializable
{

    private List<Actor> all;

    public List<Actor> getAll()
    {
        return all;
    }

    public void setAll(List<Actor> all)
    {
        this.all = all;
    }

}
