package org.nemanjamarjanovic.rekomendator.bussines.security.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static org.nemanjamarjanovic.rekomendator.bussines.security.entity.Permission.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries(
        @NamedQuery(name = FIND_ALL, query = "select p from Permission p")
)
public class Permission implements Serializable
{

    public static final String FIND_ALL = "Permission.findAll";
    private static final long serialVersionUID = 1L;

    @Id
    private String title;

    public Permission()
    {
    }

    public Permission(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

}
