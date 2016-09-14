package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.FavoriteDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.RateDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class Reports implements Serializable {

    @Inject
    private RateDao rateDao;

    @Inject
    private FavoriteDao favoriteDao;

    private List<Movie> top5Rating;
    private List<Movie> top5Favorited;
    private int month;
    private int year;
    private int users;
    private int movies;
    private int events;

    @PostConstruct
    public void init() {
        this.top5Rating = rateDao.findTopMovies(5);
        this.top5Favorited = favoriteDao.findTop5();
    }

    public void doReport() {
        this.users = 42;
        this.movies = 42;
        this.events = 42;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Movie> getTop5Rating() {
        return top5Rating;
    }

    public List<Movie> getTop5Favorited() {
        return top5Favorited;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getUsers() {
        return users;
    }

    public int getMovies() {
        return movies;
    }

    public int getEvents() {
        return events;
    }

}
