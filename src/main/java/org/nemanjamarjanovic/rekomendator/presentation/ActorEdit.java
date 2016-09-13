package org.nemanjamarjanovic.rekomendator.presentation;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.ActorDao;

/**
 *
 * @author nemanja
 */
@Model
public class ActorEdit {

    @Inject
    private ActorDao actorDao;

    private String name;

    public String doCreate() {
        actorDao.create(name);
        return "actor-list?faces-redirect=true";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
