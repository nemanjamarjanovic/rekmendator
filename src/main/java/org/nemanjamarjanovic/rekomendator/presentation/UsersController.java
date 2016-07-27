package org.nemanjamarjanovic.rekomendator.presentation;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.user.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.ApplicationUser;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.UserType;

/**
 *
 * @author nemanja
 */
@Named
@RequestScoped
public class UsersController
{

    @EJB
    UserDao userDao;

    private String username;

    public List<ApplicationUser> getUsers()
    {
        return userDao.findAll();
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void createUser()
    {
        userDao.create(username, UserType.ADMIN);
    }

}
