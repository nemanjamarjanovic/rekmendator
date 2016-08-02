package org.nemanjamarjanovic.rekomendator.bussines.security.boundary;

import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.security.control.Permission;
import org.nemanjamarjanovic.rekomendator.bussines.security.control.Role;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.User;

/**
 *
 * @author nemanja.marjanovic
 */
@Stateless
public class SecurityDao
{

    @PersistenceContext
    EntityManager entityManager;

    public void createRole(String title)
    {
        Role role = new Role();
        role.setTitle(title);
        entityManager.persist(role);
    }

    public void createPermission(String title)
    {
        Permission permission = new Permission(title);
        entityManager.persist(permission);
    }

    public void addPermissionToRole(String roleTitle, String permissionTitle)
    {
        Role role = entityManager.find(Role.class, roleTitle);
        Permission permission = entityManager.find(Permission.class, permissionTitle);
        role.addPermission(permission);
    }

    public void addRoleToUser(String roleTitle, UUID userId)
    {
        User user = entityManager.find(User.class, userId);
        Role role = entityManager.getReference(Role.class, roleTitle);
        user.setRole(role);
    }

    public User authorize(String username, String password)
    {

        return entityManager
                .createNamedQuery(User.FIND_BY_USERNAME, User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
