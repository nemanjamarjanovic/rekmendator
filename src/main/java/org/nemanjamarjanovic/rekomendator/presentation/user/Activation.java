package org.nemanjamarjanovic.rekomendator.presentation.user;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.SecurityDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja
 */
@Model
public class Activation
{

    @Inject
    private SecurityDao securityDao;
    private User selectedUser;

    public String setUserState(String userId, boolean state)
    {
        securityDao.setUserState(userId, state);
        return "/admin/users?faces-redirect=true";
    }

    public User getSelectedUser()
    {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser)
    {
        this.selectedUser = selectedUser;
    }

}
