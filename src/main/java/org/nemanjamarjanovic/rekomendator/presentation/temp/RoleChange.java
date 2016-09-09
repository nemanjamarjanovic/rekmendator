package org.nemanjamarjanovic.rekomendator.presentation.temp;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.boundary.SecurityDao;
import org.nemanjamarjanovic.rekomendator.bussines.entity.Role;
import org.nemanjamarjanovic.rekomendator.bussines.entity.User;

/**
 *
 * @author nemanja
 */
@Model
public class RoleChange
{

    private User selectedUser;
    private Role selectedRole;
    @Inject
    SecurityDao securityDao;

    public String doChange()
    {
        securityDao.promoteUser(this.selectedUser.getId(), this.selectedRole.getTitle());
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

    public Role getSelectedRole()
    {
        return selectedRole;
    }

    public void setSelectedRole(Role selectedRole)
    {
        this.selectedRole = selectedRole;
    }

}
