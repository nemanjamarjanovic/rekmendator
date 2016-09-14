package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Event;

/**
 *
 * @author nemanja
 */
@Stateless
public class EventDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Event event) {
        event.setId(UUID.randomUUID().toString());
        this.entityManager.persist(event);
    }

    public void approve(String event) {
        Event find = this.entityManager.find(Event.class, event);
        find.setApproved(true);
    }

    public Event findById(String id) {
        return entityManager.find(Event.class, id);
    }

    public List<Event> findAll() {
        return this.entityManager
                .createNamedQuery(Event.FIND_ALL, Event.class)
                .getResultList();
    }
}
