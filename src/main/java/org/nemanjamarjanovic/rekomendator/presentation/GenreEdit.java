package org.nemanjamarjanovic.rekomendator.presentation;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MovieDao;

/**
 *
 * @author nemanja
 */
@Model
public class GenreEdit {

    @Inject
    private MovieDao moviesDao;

    private String title;

    public String doCreate() {
        moviesDao.createGenre(title);
        return "genre-list?faces-redirect=true";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
