package org.nemanjamarjanovic.rekomendator.presentation.converter;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja
 */
@Named
@RequestScoped
public class UserConverter implements Converter {

    @EJB
    private UserDao userDao;

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {

        return (value == null || value.isEmpty())
                ? null : userDao.findById(value);
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {

        return (value == null) ? "" : ((User) value).getId();
    }

}
