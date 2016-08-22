package org.nemanjamarjanovic.rekomendator.bussines.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Role;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja.marjanovic
 */
@Stateless
public class SecurityDao
{

    @PersistenceContext
    EntityManager entityManager;

    public void setUserState(String userId, boolean state)
    {
        User user = entityManager.find(User.class, userId);
        user.setActive(state);
    }

    public void promoteUser(String userId, String role)
    {
        Role promotion = entityManager.getReference(Role.class, role);
        User user = entityManager.find(User.class, userId);
        user.setRole(promotion);
    }

    public User authorize(String username, String password)
    {

        return entityManager
                .createNamedQuery(User.FIND_BY_USERNAME, User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public List<Role> allRoles()
    {
        return entityManager.createNamedQuery(Role.FIND_ALL, Role.class).getResultList();
    }
}
