package org.nemanjamarjanovic.rekomendator.bussines.boundary;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Actor;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Favorite;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Genre;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Movie;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja
 */
@Stateless
public class FavoriteDao
{

    @PersistenceContext
    EntityManager entityManager;

    public Favorite findById(String id)
    {
        return entityManager.find(Favorite.class, id);
    }

    public List<Favorite> findAllByUser(String user)
    {
        return entityManager
                .createNamedQuery(Favorite.FIND_BY_USER, Favorite.class)
                .setParameter("user", user)
                .getResultList();
    }

    public void create(String movie, String user)
    {
        Favorite favorite = new Favorite();
        favorite.setId(UUID.randomUUID().toString());
        favorite.setCreatedDate(new Date());
        favorite.setUser(entityManager.getReference(User.class, user));
        favorite.setMovie(entityManager.getReference(Movie.class, movie));
        entityManager.persist(favorite);
    }

}
