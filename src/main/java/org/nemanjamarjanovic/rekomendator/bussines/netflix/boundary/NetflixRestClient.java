package org.nemanjamarjanovic.rekomendator.bussines.netflix.boundary;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.ws.rs.client.ClientBuilder;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.netflix.entity.Rss;

/**
 *
 * @author nemanja
 */
@Named
@ApplicationScoped
@Loggable
public class NetflixRestClient
{

    @Inject
    ServletContext servletContext;

    private Rss netflixRssFeed = null;

    public Rss getNetflixRssFeed()
    {

        String address = servletContext.getInitParameter("netflix.address");

        if (this.netflixRssFeed == null) {
            this.netflixRssFeed = ClientBuilder
                    .newClient()
                    .target(address)
                    .request()
                    .get()
                    .readEntity(Rss.class);
        }

        return this.netflixRssFeed;
    }

}
