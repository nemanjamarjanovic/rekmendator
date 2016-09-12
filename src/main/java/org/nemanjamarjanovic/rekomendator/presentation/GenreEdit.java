package org.nemanjamarjanovic.rekomendator.presentation;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.GenreDao;

/**
 *
 * @author nemanja
 */
@Model
public class GenreEdit {

    @Inject
    GenreDao genreDao;

    private String title;

    public String doCreate() {
        genreDao.create(title);
        return "genre-list?faces-redirect=true";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
