package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Favorite;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.User;

/**
 *
 * @author nemanja
 */
@Stateless
@Loggable
public class FavoriteDao {

    @PersistenceContext
    EntityManager entityManager;

    public Favorite findById(String id) {
        return entityManager.find(Favorite.class, id);
    }

    public List<Favorite> findByUser(String user) {
        return entityManager
                .createNamedQuery(Favorite.FIND_BY_USER, Favorite.class)
                .setParameter("user", user)
                .getResultList();
    }

    public List<Movie> findTop5() {
        List<Object[]> resultList = entityManager.createNamedQuery(Favorite.FIND_TOP5)
                .getResultList();

        return resultList
                .parallelStream()
                .map((f) -> {
                    Movie movie = (Movie) f[0];
                    movie.setRating((Long) f[1]);
                    return movie;
                })
                .collect(Collectors.toList());

    }

    public void create(String movie, String user) {
        Favorite favorite = new Favorite();
        favorite.setId(UUID.randomUUID().toString());
        favorite.setCreatedDate(new Date());
        favorite.setUser(entityManager.getReference(User.class, user));
        favorite.setMovie(entityManager.getReference(Movie.class, movie));
        entityManager.persist(favorite);
    }

}
