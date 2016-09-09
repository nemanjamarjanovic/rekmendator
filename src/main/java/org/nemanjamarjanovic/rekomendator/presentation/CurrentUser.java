package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja
 */
@Named
@SessionScoped
public class CurrentUser implements Serializable {

    @Inject
    UserDao userDao;

    private String username;
    private String password;

    private String id;
    private String name;

    public String doLogin() {
        User user = userDao.findByUsername(this.username, this.password);
        this.id = user.getId();
        this.name = user.getName();
        this.username = null;
        this.password = null;
        return "/pages/movie-list?faces-redirect=true";
    }

    public String doLogout() {
        this.id = null;
        this.name = null;
        return "/index?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    

}
