package org.nemanjamarjanovic.rekomendator.bussines.omdb.boundary;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.omdb.entity.OmdbMovie;

/**
 *
 * @author nemanja
 */
@ApplicationScoped
public class OmdbClient
{

    @Inject
    private ServletContext servletContext;

    private WebTarget service;

    @PostConstruct
    public void omdbClient()
    {
        this.service = ClientBuilder
                .newClient()
                .target(servletContext.getInitParameter("omdb.address"));
    }

    @Loggable
    public OmdbMovie search(String title)
    {
        return this.service
                .queryParam("t", title)
                .request()
                .get()
                .readEntity(OmdbMovie.class);

    }

}
