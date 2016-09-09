package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.FavoriteDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Favorite;

/**
 *
 * @author nemanja
 */
@Model
public class FavoriteEdit implements Serializable
{

    @Inject
    private FavoriteDao favoriteDao;

    @Inject
    private CurrentUser currentUser;

    public String doFavorite(String movie)
    {
        favoriteDao.create(movie, currentUser.getId());
        return "movie-view?faces-redirect=true&id=" + movie;
    }

    public boolean isFavorited(String movie)
    {
        return favoriteDao.findAllByUser(currentUser.getId()).parallelStream().map(f -> f.getMovie().getId()).anyMatch(f -> (f.equals(movie)));
    }

}
