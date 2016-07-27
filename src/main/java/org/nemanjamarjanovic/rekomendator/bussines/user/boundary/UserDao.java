package org.nemanjamarjanovic.rekomendator.bussines.user.boundary;

import java.util.List;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.ApplicationUser;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.UserType;

/**
 *
 * @author nemanja
 */
public interface UserDao
{

    void create(String username, UserType type);

    List<ApplicationUser> findAll();
    
}
