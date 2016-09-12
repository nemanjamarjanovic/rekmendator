package org.nemanjamarjanovic.rekomendator.presentation.converter;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.ActorDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;

/**
 *
 * @author nemanja
 */
@Named
@RequestScoped
public class ActorConverter implements Converter {

    @EJB
    private ActorDao actorDao;

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {

        return (value == null || value.isEmpty())
                ? null : actorDao.findById(value);
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {

        return (value == null) ? "" : ((Actor) value).getId();
    }

}
