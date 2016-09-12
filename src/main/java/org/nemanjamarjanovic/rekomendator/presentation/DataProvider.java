package org.nemanjamarjanovic.rekomendator.presentation;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.ActorDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.GenreDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.MovieDao;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.RoleDao;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.User;

/**
 *
 * @author nemanja
 */
public class DataProvider {

    @Inject
    private GenreDao genreDao;

    @Inject
    private UserDao userDao;

    @Inject
    private RoleDao roleDao;
    
    @Inject
    private ActorDao actorDao;

    @Produces
    @Named
    public List<Genre> getAllGenres() {
        return genreDao.findAll();
    }

    @Produces
    @Named
    public List<Actor> getAllActors() {
        return actorDao.findAll();
    }

    @Produces
    @Named
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Produces
    @Named
    public List<String> getAllRoles() {
        return roleDao.findAll().parallelStream().map(f->f.getTitle()).collect(Collectors.toList());
    }
}
