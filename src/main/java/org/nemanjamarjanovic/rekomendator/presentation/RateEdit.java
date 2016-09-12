package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.RateDao;

/**
 *
 * @author nemanja
 */
@Model
public class RateEdit implements Serializable {

    @Inject
    private RateDao rateDao;

    @Inject
    private CurrentUser currentUser;

    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String doRate(String movie) {
        rateDao.create(movie, currentUser.getId(), this.rating);
        return "movie-view?faces-redirect=true&id=" + movie;
    }

    public boolean isRated(String movie) {
        return rateDao
                .findByUser(currentUser.getId())
                .parallelStream()
                .map(f -> f.getMovie().getId())
                .anyMatch(f -> (f.equals(movie)));
    }

    public double currentRating(String movie) {
        double current = 0;
        try {
            current = rateDao.findAveageByMovie(movie);
        } catch (Exception e) {
        }
        return current;
    }

    public int userRating(String movie) {
        return rateDao
                .findByUser(currentUser.getId())
                .parallelStream()
                .filter(f -> f.getMovie().getId().equals(movie))
                .findFirst()
                .get()
                .getValue();
    }

}
