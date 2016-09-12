package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;

/**
 *
 * @author nemanja.marjanovic
 */
@Stateless
@Loggable
public class ActorDao
{

    @PersistenceContext
    EntityManager entityManager;

    public Actor findById(String id)
    {
        return entityManager.find(Actor.class, id);
    }

    public List<Actor> findAll()
    {
        return entityManager
                .createNamedQuery(Actor.FIND_ALL, Actor.class)
                .getResultList();
    }

    public Actor create(String title)
    {
        Actor actor = new Actor(title);
        entityManager.persist(actor);
        return actor;
    }
}
