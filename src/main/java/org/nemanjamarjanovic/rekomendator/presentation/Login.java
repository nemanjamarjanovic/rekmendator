package org.nemanjamarjanovic.rekomendator.presentation;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.SecurityDao;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.User;
import org.nemanjamarjanovic.rekomendator.presentation.user.UserContext;

/**
 *
 * @author nemanja.marjanovic
 */
@Model
public class Login
{

    private String username;
    private String password;

    @Inject
    UserContext userContext;

    @EJB
    SecurityDao securityDao;

    public String doLogin()
    {
        User user = securityDao.authorize(this.username, this.password);
        userContext.setCurrent(user.getUsername());
        userContext.setPermissions(user.getRole().getPermissions());
        return "index?faces-redirect=true";
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

}
