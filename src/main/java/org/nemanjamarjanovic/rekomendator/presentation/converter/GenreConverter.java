package org.nemanjamarjanovic.rekomendator.presentation.converter;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.MovieDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Genre;

/**
 *
 * @author nemanja
 */
@Named
@RequestScoped
public class GenreConverter implements Converter {

    @EJB
    private MovieDao moviesDao;

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {

        return (value == null || value.isEmpty())
                ? null : moviesDao.findGenreById(value);
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {

        return (value == null) ? "" : ((Genre) value).getTitle();
    }

}
