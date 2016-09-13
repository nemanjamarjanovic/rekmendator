package org.nemanjamarjanovic.rekomendator.bussines.omdb.boundary;

import java.io.StringReader;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.omdb.entity.OmdbMovie;

/**
 *
 * @author nemanja
 */
@ApplicationScoped
public class OmdbClient {

    @Inject
    private ServletContext servletContext;

    private WebTarget service;

    @PostConstruct
    public void omdbClient() {
        this.service = ClientBuilder
                .newClient()
                .target(servletContext.getInitParameter("omdb.address"));
    }

    @Loggable
    public OmdbMovie search(String title) {

        String readEntity = this.service
                .queryParam("t", title)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(String.class);

        JsonReader jsonReader = Json.createReader(new StringReader(readEntity));
        JsonObject object = jsonReader.readObject();
        OmdbMovie movie = new OmdbMovie(
                object.getString("Title"),
                object.getString("Year"),
                object.getString("Runtime"),
                object.getString("Genre"),
                object.getString("Director"),
                object.getString("Actors"),
                object.getString("Plot"),
                object.getString("Poster"),
                object.getString("imdbRating"));

        jsonReader.close();
        return movie;
    }

}
