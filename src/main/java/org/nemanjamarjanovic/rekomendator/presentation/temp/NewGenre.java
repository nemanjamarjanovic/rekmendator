package org.nemanjamarjanovic.rekomendator.presentation.temp;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MoviesDao;

/**
 *
 * @author nemanja
 */
@Model
public class NewGenre
{

    @Inject
    private MoviesDao moviesDao;

    private String title;

    public String doCreate()
    {
        moviesDao.createGenre(title);
        return "genres?faces-redirect=true";
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

}
