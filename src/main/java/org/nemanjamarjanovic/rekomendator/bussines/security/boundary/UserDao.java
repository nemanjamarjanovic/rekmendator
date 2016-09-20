package org.nemanjamarjanovic.rekomendator.bussines.security.boundary;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.security.control.HashedPassword;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.Role;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.User;
import static org.nemanjamarjanovic.rekomendator.bussines.security.entity.User.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Stateless
@Loggable
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public User create(User user) throws NoSuchAlgorithmException {
        User newUser = new User();
        newUser.setId(UUID.randomUUID().toString());
        newUser.setActive(false);
        newUser.setUsername(user.getUsername());

        HashedPassword hashedPassword = new HashedPassword(user.getPassword());
        newUser.setPassword(hashedPassword.getValue());

        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setMbr(user.getMbr());
        newUser.setEmail(user.getEmail());
        newUser.setLang(user.getLang());
        Role registered = entityManager.getReference(Role.class, "USER");
        newUser.setRole(registered);
        newUser.setActive(true);
        entityManager.persist(newUser);
        return newUser;
    }

    public void update(User user) throws NoSuchAlgorithmException {
        User edited = entityManager.find(User.class, user.getId());

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            HashedPassword hashedPassword = new HashedPassword(user.getPassword());
            edited.setPassword(hashedPassword.getValue());
        }

        edited.setName(user.getName());
        edited.setSurname(user.getSurname());
        edited.setMbr(user.getMbr());
        edited.setEmail(user.getEmail());
        edited.setLang(user.getLang());
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

    public User findByUsername(String username, String password)
            throws NoSuchAlgorithmException, NoResultException {

        HashedPassword hashedPassword = new HashedPassword(password);

        List<User> resultList = entityManager
                .createNamedQuery(User.FIND_BY_USERNAME, User.class)
                .setParameter("username", username)
                .setParameter("password", hashedPassword.getValue())
                .getResultList();

        return (resultList.isEmpty()) ? null : resultList.get(0);
    }

}
