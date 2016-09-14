package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.EventDao;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class EventList implements Serializable {

    @Inject
    EventDao eventDao;

    private Pagination pagination;

    @PostConstruct
    public void init() {

        this.pagination = new Pagination(eventDao.findAll(), 5);
    }

    public Pagination getPagination() {
        return pagination;
    }

}
