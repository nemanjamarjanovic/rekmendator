package org.nemanjamarjanovic.rekomendator.bussines.security.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.Role;

/**
 *
 * @author nemanja.marjanovic
 */
@Stateless
@Loggable
public class RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Role> findAll() {
        return entityManager.createNamedQuery(Role.FIND_ALL, Role.class).getResultList();
    }

    public Role findById(String id) {
        return entityManager.find(Role.class, id);
    }
}
