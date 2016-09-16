package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.UserDao;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.Page;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.User;

/**
 *
 * @author nemanja
 */
@Named
@SessionScoped
public class CurrentUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    UserDao userDao;

    private String username;
    private String password;

    private String id;
    private String name;
    private Set<String> permissions = new HashSet<>();
    private List<Page> pages = new ArrayList<>();

    public String doLogin() throws NoSuchAlgorithmException {
        User user = userDao.findByUsername(this.username, this.password);
        this.id = user.getId();
        this.name = user.getName();
        this.username = null;
        this.password = null;
        this.permissions = user.getRole().getPermissions().stream().map(p -> p.getTitle()).collect(Collectors.toSet());
        this.pages = user.getRole().getPages().stream().map(p -> p).collect(Collectors.toList());
        this.pages.size();
        
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("de"));
        
        return "/pages/event-list?faces-redirect=true";
    }

    public String doLogout() {
        this.id = null;
        this.name = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
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

    public boolean hasPermission(String permission) {
        return this.permissions.contains(permission);
    }

    public boolean canAccessPage(String page) {
        return this.pages.stream().map(p -> p.getPage()).collect(Collectors.toSet()).contains(page);
    }

    public List<Page> getPages()
    {
        return pages;
    }

    public Set<String> getPermissions()
    {
        return permissions;
    }

    
}
