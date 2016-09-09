package org.nemanjamarjanovic.rekomendator.bussines.boundary;

import java.util.List;
import java.util.UUID;
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
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public User create(User user) {
        User newUser = new User();
        newUser.setId(UUID.randomUUID().toString());
        newUser.setActive(false);
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

    public void update(User user) {
        User edited = entityManager.find(User.class, user.getId());
        edited.setPassword(user.getPassword());
        edited.setName(user.getName());
        edited.setSurname(user.getSurname());
        edited.setMbr(user.getMbr());
        edited.setEmail(user.getEmail());
    }

    public List<User> findAll() {
        return entityManager
                .createNamedQuery(FIND_ALL, User.class)
                .getResultList();
    }

    public User findById(String id) {
        return entityManager.find(User.class, id);
    }

    public void setUserState(String userId, boolean state) {
        User user = entityManager.find(User.class, userId);
        user.setActive(state);
    }

    public void setUserRole(String userId, String role) {
        Role promotion = entityManager.getReference(Role.class, role);
        User user = entityManager.find(User.class, userId);
        user.setRole(promotion);
    }

    public User findByUsername(String username, String password) {

        return entityManager
                .createNamedQuery(User.FIND_BY_USERNAME, User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

}
