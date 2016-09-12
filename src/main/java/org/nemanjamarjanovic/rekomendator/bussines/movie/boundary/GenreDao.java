package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;

/**
 *
 * @author nemanja
 */
@Stateless
@Loggable
public class GenreDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Genre> findAll() {
        return entityManager
                .createNamedQuery(Genre.FIND_ALL, Genre.class)
                .getResultList();
    }

    public Genre create(String title) {
        Genre genre = new Genre(title);
        entityManager.persist(genre);
        return genre;
    }

    public Genre findById(String id) {
        return entityManager.find(Genre.class, id);
    }

}
