package org.nemanjamarjanovic.rekomendator.bussines.rss.boundary;

import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.rss.entity.Channel;
import org.nemanjamarjanovic.rekomendator.bussines.rss.entity.Item;
import org.nemanjamarjanovic.rekomendator.bussines.rss.entity.Rss;

/**
 *
 * @author nemanja.marjanovic
 */
@Path("Top5")
@Loggable
public class TopMoviesRss {

    @Inject
    private RateDao rateDao;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response get(@Context UriInfo uriInfo) {

        String uri = uriInfo.getBaseUri().toString();
        String link = uri.substring(0, uri.length() - 5) + "/faces/pages/movie-view.xhtml?id=";

        List<Item> result = rateDao
                .findTopMovies(5)
                .parallelStream()
                .map(f -> new Item(
                        f.getTitle(),
                        f.getDescription(),
                        link + f.getId(),
                        (Double) f.getRating()))
                .collect(Collectors.toList());

        Channel channel = new Channel();
        channel.setItems(result);
        channel.setDescription("Top 5 rated movies");
        Rss rss = new Rss();
        rss.setVersion("2.0");
        rss.setChannel(channel);
        return Response.ok(rss).build();
    }

}
