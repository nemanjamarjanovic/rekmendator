package org.nemanjamarjanovic.rekomendator.bussines.security.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import static org.nemanjamarjanovic.rekomendator.bussines.security.entity.Role.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries(
        @NamedQuery(name = FIND_ALL, query = "select r from Role r")
)
public class Role implements Serializable
{

    public static final String FIND_ALL = "Role.findAll";
    private static final long serialVersionUID = 1L;

    @Id
    private String title;

    @OneToMany
    private Set<Permission> permissions;

    @OneToMany(fetch=FetchType.EAGER)
    private Set<Page> pages;

    public Role()
    {
        this.permissions = new HashSet<>(10);
        this.pages = new HashSet<>(10);
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Set<Permission> getPermissions()
    {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions)
    {
        this.permissions = permissions;
    }

    public Set<Page> getPages()
    {
        return pages;
    }

    public void setPages(Set<Page> pages)
    {
        this.pages = pages;
    }

  
    
    

}
