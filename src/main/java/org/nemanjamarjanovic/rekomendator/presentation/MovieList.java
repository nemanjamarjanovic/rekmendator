package org.nemanjamarjanovic.rekomendator.presentation;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.FavoriteDao;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MovieDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Movie;

/**
 *
 * @author nemanja.marjanovic
 */
@Model
public class MovieList
{

    @Inject
    MovieDao moviesDao;

    @Inject
    FavoriteDao favoriteDao;

    @Inject
    private CurrentUser currentUser;

    private List<Movie> data;
    private boolean favorites;

    public void init()
    {
        if (this.favorites) {
            this.data = favoriteDao.findAllByUser(currentUser.getId()).parallelStream().map(f -> f.getMovie()).collect(Collectors.toList());
        }
        else {
            data = moviesDao.findAllMovies();
        }
    }

    public List<Movie> getData()
    {
        return data;
    }

    public void setData(List<Movie> data)
    {
        this.data = data;
    }

    public boolean isFavorites()
    {
        return favorites;
    }

    public void setFavorites(boolean favorites)
    {
        this.favorites = favorites;
    }

}
