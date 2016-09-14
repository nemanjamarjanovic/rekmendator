package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja
 */
@Stateless
@Loggable
public class MovieDao
{

    @PersistenceContext
    EntityManager entityManager;

    public Movie findById(String id)
    {
        return entityManager.find(Movie.class, id);
    }

    public List<Movie> findAll()
    {
        return entityManager
                .createNamedQuery(Movie.FIND_ALL, Movie.class)
                .getResultList();
    }

    public List<Movie> search(String title, String publishingDate, List<Genre> genres)
    {

        String titleParam = (title == null || title.isEmpty()) ? null : "%" + title.trim() + "%";
        String pdParam = (publishingDate == null || publishingDate.isEmpty()) ? null : publishingDate.trim();
        
        if (titleParam == null && pdParam == null) {
            return Collections.emptyList();
        }

        return entityManager
                .createNamedQuery(Movie.SEARCH, Movie.class)
                .setParameter("title", titleParam)
                .setParameter("publishingDate", pdParam)
                .getResultList();
    }

    public Movie createMovie(final Movie data, List<String> actors)
    {

        Movie movie = new Movie();
        movie.setId(UUID.randomUUID().toString());
        movie.setTitle(data.getTitle());
        movie.setDuration(data.getDuration());
        movie.setDescription(data.getDescription());
        movie.setPublishingDate(data.getPublishingDate());
        movie.setYoutube(data.getYoutube());

        movie.setGenre(new HashSet<>(10));
        data.getGenre().stream().map(g -> entityManager
                .getReference(Genre.class, g.getTitle()))
                .forEach(g -> movie.getGenre().add(g));

        movie.setActors(new HashSet<>(10));
        actors.stream().forEach((actor) -> {

            Actor actorEntity = entityManager.find(Actor.class, actor);
            if (actorEntity == null) {
                actorEntity = new Actor(actor);
                entityManager.persist(actorEntity);
            }
            movie.getActors().add(actorEntity);
        });

        entityManager.persist(movie);

        return movie;
    }

    public Movie updateMovie(final Movie data, List<String> actors)
    {

        Movie movie = entityManager.find(Movie.class, data.getId());

        movie.setTitle(data.getTitle());
        movie.setDuration(data.getDuration());
        movie.setDescription(data.getDescription());
        movie.setPublishingDate(data.getPublishingDate());
        movie.setYoutube(data.getYoutube());

        movie.setGenre(new HashSet<>(10));
        data.getGenre().stream().map(g -> entityManager
                .getReference(Genre.class, g.getTitle()))
                .forEach(g -> movie.getGenre().add(g));

        movie.setActors(new HashSet<>(10));
        actors.stream().forEach((actor) -> {

            Actor actorEntity = entityManager.find(Actor.class, actor);
            if (actorEntity == null) {
                actorEntity = new Actor(actor);
                entityManager.persist(actorEntity);
            }
            movie.getActors().add(actorEntity);
        });

        return movie;
    }

    public void trailerUploaded(String id)
    {
        Movie movie = entityManager.find(Movie.class, id);
        movie.setTrailer(true);
    }

}
