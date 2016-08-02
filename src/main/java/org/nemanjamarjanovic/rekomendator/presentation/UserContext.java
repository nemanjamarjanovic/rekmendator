package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.SecurityDao;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.User;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@SessionScoped
public class UserContext implements Serializable
{

    private String username;
    private String password;

    private Set<String> permissions = new HashSet<>();
    private String current;

    @EJB
    SecurityDao securityDao;

    @PostConstruct
    public void init()
    {
        this.username = "guest";
        this.password = "guest";
        authenticate();
    }

    private boolean authenticate()
    {
        boolean result = false;
        try {
            User user = securityDao.authorize(this.username, this.password);
            this.current = user.getUsername();
            this.permissions = user.getRole().getPermissions().stream().map(p -> p.getTitle()).collect(Collectors.toSet());
        }
        catch (Exception e) {
            result = false;
        }

        this.clearFields();
        return result;
    }

    public String authorize(String permission)
    {
        return (this.permissions.contains(permission)) ? null : "/login?faces-redirect=true";
    }

    public String doLogin()
    {
        this.authenticate();
        return "/index?faces-redirect=true";
    }

    public String doLogout()
    {
        this.init();
        return "/index?faces-redirect=true";
    }

    public boolean hasPermission(String permission)
    {
        return permissions.contains(permission);
    }

    private void clearFields()
    {
        this.username = "";
        this.password = "";
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCurrent()
    {
        return current;
    }

    public void setCurrent(String current)
    {
        this.current = current;
    }
}
