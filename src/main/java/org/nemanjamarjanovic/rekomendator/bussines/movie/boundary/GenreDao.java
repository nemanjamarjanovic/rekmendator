package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;

/**
 *
 * @author nemanja
 */
@Stateless
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
