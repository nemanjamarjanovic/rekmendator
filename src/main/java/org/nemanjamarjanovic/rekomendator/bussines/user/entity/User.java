package org.nemanjamarjanovic.rekomendator.bussines.user.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import org.nemanjamarjanovic.rekomendator.bussines.security.control.Role;
import static org.nemanjamarjanovic.rekomendator.bussines.user.entity.User.*;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select u from User u"),
        @NamedQuery(name = FIND_BY_USERNAME, query = "select u from User u where u.username = :username ")
})
public class User implements Serializable
{

    public static final String FIND_ALL = "User.findAll";
    public static final String FIND_BY_USERNAME = "User.findByUsername";

    @Id
    private String id;

    private String username;
    private String password;

    private Role role;

    @PrePersist
    public void generateId()
    {
        id = UUID.randomUUID().toString();
    }

    public String getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

}
