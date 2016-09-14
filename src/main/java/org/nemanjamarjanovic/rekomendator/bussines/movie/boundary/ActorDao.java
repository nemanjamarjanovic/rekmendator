package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

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

}
