package org.nemanjamarjanovic.rekomendator.presentation.converter;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.RoleDao;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.Role;

/**
 *
 * @author nemanja
 */
@Named
@RequestScoped
public class RoleConverter implements Converter {

    @EJB
    private RoleDao roleDao;

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {

        return (value == null || value.isEmpty())
                ? null : roleDao.findById(value);
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {

        return (value == null) ? "" : ((Role) value).getTitle();
    }

}
