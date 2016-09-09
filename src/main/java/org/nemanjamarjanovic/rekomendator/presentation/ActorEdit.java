package org.nemanjamarjanovic.rekomendator.presentation;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MovieDao;

/**
 *
 * @author nemanja
 */
@Model
public class ActorEdit {

    @Inject
    private MovieDao moviesDao;

    private String name;

    public String doCreate() {
        moviesDao.createActor(name);
        return "actor-list?faces-redirect=true";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
