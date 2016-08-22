package org.nemanjamarjanovic.rekomendator.presentation.user;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja
 */
@Model
public class Registration implements Serializable
{

    @Inject
    private UserDao userDao;

    private User newUser = new User();

    public String doCreate()
    {
        userDao.create(newUser);
        return "index?faces-redirect=true";
    }

    public User getNewUser()
    {
        return newUser;
    }

    public void setNewUser(User newUser)
    {
        this.newUser = newUser;
    }
    
    

}
