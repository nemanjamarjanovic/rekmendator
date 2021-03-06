package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.User;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class UserEdit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserDao userDao;
    
    @Inject
    ServletContext servletContext;

    private User data = new User();
    
    public void init(){
        this.data.setPassword(null);
    }

    public String doRegister() throws NoSuchAlgorithmException {

        data.setLang(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage());
        userDao.create(data);
        return "/index?faces-redirect=true";
    }

    public String doUpdate() throws NoSuchAlgorithmException {
        userDao.update(data);
        return "/index?faces-redirect=true";
    }

    public String doStateChange(String id) {
        userDao.setUserState(id, !data.isActive());
        return "user-list?faces-redirect=true";
    }

    public String doRoleChange(String role) {
        userDao.setUserRole(this.data.getId(), role);
        return "user-list?faces-redirect=true";
    }

    public void doSaveImage(ValueChangeEvent event) {
        Part file = (Part) event.getNewValue();
        try (InputStream input = file.getInputStream()) {
            Files.copy(input,
                    new File(servletContext.getInitParameter("upload.location")
                            + File.separator + "user",
                            this.data.getId()).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

}
