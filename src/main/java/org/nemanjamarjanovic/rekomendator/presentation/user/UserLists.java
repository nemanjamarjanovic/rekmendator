package org.nemanjamarjanovic.rekomendator.presentation.user;

import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja.marjanovic
 */
public class UserLists
{

    @Inject
    UserDao userDao;

    @Produces
    @Named
    public List<User> getAllUsers()
    {
        return userDao.findAll();
    }

}
