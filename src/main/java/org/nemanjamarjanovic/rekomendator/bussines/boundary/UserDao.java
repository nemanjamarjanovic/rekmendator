package org.nemanjamarjanovic.rekomendator.bussines.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Role;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;
import static org.nemanjamarjanovic.rekomendator.bussines.entity.User.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Stateless
public class UserDao
{

    @PersistenceContext
    EntityManager entityManager;

    public User create(User user)
    {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setMbr(user.getMbr());
        newUser.setEmail(user.getEmail());
        Role registered = entityManager.getReference(Role.class, "USER");
        user.setRole(registered);
        entityManager.persist(newUser);
        return newUser;
    }

    public List<User> findAll()
    {
        return entityManager.createNamedQuery(FIND_ALL, User.class).getResultList();
    }

}
