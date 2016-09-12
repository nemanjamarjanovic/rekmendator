package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.User;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class UserEdit implements Serializable {

    @Inject
    private UserDao userDao;

    private User data = new User();

    public String doRegister() throws NoSuchAlgorithmException {
        userDao.create(data);
        return "/index?faces-redirect=true";
    }

    public String doUpdate() throws NoSuchAlgorithmException {
        userDao.update(data);
        return "user-list?faces-redirect=true";
    }

    public String doStateChange(String id) {
        userDao.setUserState(id, !data.isActive());
        return "user-list?faces-redirect=true";
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

}
