package org.nemanjamarjanovic.rekomendator.bussines.user.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.User;
import static org.nemanjamarjanovic.rekomendator.bussines.user.entity.User.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Stateless
public class UserDao
{

    @PersistenceContext
    EntityManager entityManager;

    public User create(String username)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(username);
        entityManager.persist(user);
        return user;
    }

    public List<User> findAll()
    {
        return entityManager.createNamedQuery(FIND_ALL, User.class).getResultList();
    }
}
