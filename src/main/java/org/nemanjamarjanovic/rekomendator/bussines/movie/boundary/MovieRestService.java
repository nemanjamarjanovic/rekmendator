package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja.marjanovic
 */
@Path("movies")
@Loggable
public class MovieRestService
{

    @Inject
    private MovieDao movieDao;

    @Inject
    GenreDao genreDao;
    
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response findByGenre(
            @NotNull
            @Size(min = 3, max = 60)
            @QueryParam("genre") String genre)
    {

        Genre selectedGenre = genreDao.findById(genre);
        
        List<Movie> result= movieDao
                .findAll()
                .parallelStream()
                .filter(f->f.getGenre().contains(selectedGenre))
                .collect(Collectors.toList());
        
        return Response.ok(new GenericEntity<List<Movie>>(result) {}).build();
    }

}
