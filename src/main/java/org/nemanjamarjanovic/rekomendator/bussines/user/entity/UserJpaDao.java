package org.nemanjamarjanovic.rekomendator.bussines.user.entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.user.boundary.UserDao;
import static org.nemanjamarjanovic.rekomendator.bussines.user.entity.ApplicationUser.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Stateless
public class UserJpaDao implements UserDao
{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(String username, UserType type)
    {
        ApplicationUser user = new ApplicationUser(username, type);
        entityManager.persist(user);
    }

    @Override
    public List<ApplicationUser> findAll()
    {
        return entityManager.createNamedQuery(FIND_ALL, ApplicationUser.class).getResultList();
    }
}
