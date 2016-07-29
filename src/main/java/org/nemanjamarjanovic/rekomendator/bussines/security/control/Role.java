package org.nemanjamarjanovic.rekomendator.bussines.security.control;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import static org.nemanjamarjanovic.rekomendator.bussines.security.control.Role.FIND_ALL;

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

    @Id
    private String title;

    @OneToMany
    private Set<Permission> permissions;

    public Role()
    {
        this.permissions = new HashSet<>(10);
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

    public void addPermission(Permission permission)
    {
        this.permissions.add(permission);
    }

}
