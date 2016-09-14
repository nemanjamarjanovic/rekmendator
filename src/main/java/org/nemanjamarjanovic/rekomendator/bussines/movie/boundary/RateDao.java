package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Rate;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.User;

/**
 *
 * @author nemanja
 */
@Stateless
@Loggable
public class RateDao {

    @PersistenceContext
    EntityManager entityManager;

    public Rate findById(String id) {
        return entityManager.find(Rate.class, id);
    }

    public List<Rate> findByUser(String user) {
        return entityManager
                .createNamedQuery(Rate.FIND_BY_USER, Rate.class)
                .setParameter("user", user)
                .getResultList();
    }

    public double findAveageByMovie(String movie) {
        return entityManager
                .createNamedQuery(Rate.FIND_AVERAGE_BY_MOVIE, Double.class)
                .setParameter("movie", movie)
                .getSingleResult();
    }

    public List<Movie> findTopMovies(int limit) {

        List<Object[]> resultList = entityManager
                .createNamedQuery(Rate.FIND_TOP_MOVIES)
                .setMaxResults(limit)
                .getResultList();

        return resultList
                .parallelStream()
                .map((f) -> {
                    Movie movie = (Movie) f[0];
                    movie.setRating((Double) f[1]);
                    return movie;
                })
                .collect(Collectors.toList());
    }

    public void create(String movie, String user, int rating) {
        Rate rate = new Rate();
        rate.setId(UUID.randomUUID().toString());
        rate.setCreatedDate(new Date());
        rate.setUser(entityManager.getReference(User.class, user));
        rate.setMovie(entityManager.getReference(Movie.class, movie));
        rate.setValue(rating);
        entityManager.persist(rate);
    }

}
