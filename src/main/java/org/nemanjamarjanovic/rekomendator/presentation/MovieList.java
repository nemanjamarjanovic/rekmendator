package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.FavoriteDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.MovieDao;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@ViewScoped
public class MovieList implements Serializable {

    @Inject
    MovieDao moviesDao;

    @Inject
    FavoriteDao favoriteDao;

    @Inject
    private CurrentUser currentUser;

    private String src;
    private String title;
    private String publishingDate;
    private Pagination pagination;

    public void init() {
        switch (this.src) {
            case "favorite":
                this.pagination = new Pagination(
                        favoriteDao.findByUser(currentUser.getId())
                        .parallelStream()
                        .map(f -> f.getMovie())
                        .collect(Collectors.toList()), 3);
                break;
            case "all":
                this.pagination = new Pagination(moviesDao.findAllMovies(), 3);
                break;
            case "search":
            default:
                this.pagination = new Pagination(Collections.EMPTY_LIST, 1);
        }
    }

    public void doSearch() {

//        Date pd;
//        try {
//            pd = new SimpleDateFormat("dd.MM.yyyy").parse(this.publishingDate);
//        } catch (ParseException ex) {
//            pd = null;
//        }
        this.pagination = new Pagination(
                moviesDao.search(this.title, null, null), 5);
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
