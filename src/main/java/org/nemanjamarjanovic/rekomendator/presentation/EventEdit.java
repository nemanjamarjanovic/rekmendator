package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.EventDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Event;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class EventEdit implements Serializable
{

    @Inject
    private EventDao eventDao;

    private Event data = new Event();

    public String doCreate() {
        eventDao.create(data);
        return "event-list?faces-redirect=true";
    }

    public String doApprove(String event) {
        eventDao.approve(event);
        return "event-list?faces-redirect=true";
    }

    public Event getData() {
        return data;
    }

    public void setData(Event data) {
        this.data = data;
    }

}
