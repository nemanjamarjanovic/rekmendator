package org.nemanjamarjanovic.rekomendator.presentation.user;

import java.io.Serializable;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.SecurityDao;
import org.nemanjamarjanovic.rekomendator.bussines.security.control.Permission;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.User;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@SessionScoped
public class UserContext implements Serializable
{

    private Set<Permission> permissions;
    private String current;

    @EJB
    SecurityDao securityDao;

    @PostConstruct
    public void init()
    {
        User user = securityDao.authorize("guest", "guest");
        current = user.getUsername();
        permissions = user.getRole().getPermissions();
    }

    public String doLogout()
    {
        this.init();
        return "index?faces-redirect=true";
    }

    public String getCurrent()
    {
        return current;
    }

    public void setCurrent(String current)
    {
        this.current = current;
    }

    public boolean hasPermission(String permission)
    {
        if (this.permissions == null) {
            return false;
        }

        return permissions.stream().map(p -> p.getTitle()).anyMatch(p -> p.equals(permission));

    }

    public void setPermissions(Set<Permission> permissions)
    {
        this.permissions = permissions;
    }

}
