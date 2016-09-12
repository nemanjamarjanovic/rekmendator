package org.nemanjamarjanovic.rekomendator.presentation.converter;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.GenreDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;

/**
 *
 * @author nemanja
 */
@Named
@RequestScoped
public class GenreConverter implements Converter {

    @EJB
    private GenreDao genreDao;

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {

        return (value == null || value.isEmpty())
                ? null : genreDao.findById(value);
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {

        return (value == null) ? "" : ((Genre) value).getTitle();
    }

}
