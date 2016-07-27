package org.nemanjamarjanovic.rekomendator.bussines.user.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static org.nemanjamarjanovic.rekomendator.bussines.user.entity.ApplicationUser.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries(
        @NamedQuery(name = FIND_ALL, query = "select au from ApplicationUser au")
)
public class ApplicationUser implements Serializable
{

    public static final String FIND_ALL  = "ApplicationUser.findAll";

    @Id
    private UUID id;

    private String username;
    private String password;
    private UserType type;

    public ApplicationUser()
    {
    }

    public ApplicationUser(String username, UserType type)
    {
        id = UUID.randomUUID();
        this.username = username;
        this.password = new String(new BigInteger(username.getBytes()).add(BigInteger.valueOf(42)).toByteArray());
        this.type = type;
    }

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
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

    public UserType getType()
    {
        return type;
    }

    public void setType(UserType type)
    {
        this.type = type;
    }

}
