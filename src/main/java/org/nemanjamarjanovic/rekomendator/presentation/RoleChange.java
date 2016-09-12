package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.Role;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class RoleChange implements Serializable {

    @Inject
    private UserDao userDao;

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String doRoleChange(String user) {
        userDao.setUserRole(user, this.role);
        return "user-list?faces-redirect=true&id=" + user;
    }
}
