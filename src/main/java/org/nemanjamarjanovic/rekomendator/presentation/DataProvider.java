package org.nemanjamarjanovic.rekomendator.presentation;

import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MovieDao;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.SecurityDao;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Movie;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Role;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja
 */
public class DataProvider {

    @Inject
    MovieDao moviesDao;

    @Inject
    UserDao userDao;

    @Inject
    SecurityDao securityDao;

    @Produces
    @Named
    public List<Genre> getAllGenres() {
        return moviesDao.findAllGenres();
    }

    @Produces
    @Named
    public List<Actor> getAllActors() {
        return moviesDao.findAllActors();
    }

    @Produces
    @Named
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Produces
    @Named
    public List<Role> getAllRoles() {
        return securityDao.allRoles();
    }
}
