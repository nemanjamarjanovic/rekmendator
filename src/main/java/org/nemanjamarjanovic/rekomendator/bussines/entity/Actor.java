package org.nemanjamarjanovic.rekomendator.bussines.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static org.nemanjamarjanovic.rekomendator.bussines.entity.Actor.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries(
        @NamedQuery(name = FIND_ALL, query = "select a from Actor a")
)
public class Actor implements Serializable
{

    public static final String FIND_ALL = "Actor.findAll";

    @Id
    private String id;

    private String name;

    public Actor()
    {
    }

    public Actor(String name)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
