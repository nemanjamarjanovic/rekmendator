package org.nemanjamarjanovic.rekomendator.bussines.netflix.boundary;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import org.nemanjamarjanovic.rekomendator.bussines.netflix.entity.Rss;

/**
 *
 * @author nemanja
 */
@Named
@ApplicationScoped
public class NetflixRestClient {

    private Rss netflixRssFeed = null;

    public Rss getNetflixRssFeed() {

        if (this.netflixRssFeed == null) {
            this.netflixRssFeed = ClientBuilder
                    .newClient()
                    .target("http://dvd.netflix.com/Top100RSS")
                    .request()
                    .get()
                    .readEntity(Rss.class);
        }
        
        Logger.getLogger("NetflixRestClient").log(Level.INFO, "NETFLIX RSS");

        return this.netflixRssFeed;
    }

}
