package org.nemanjamarjanovic.rekomendator.bussines.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static org.nemanjamarjanovic.rekomendator.bussines.entity.Genre.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries(
        @NamedQuery(name = FIND_ALL, query = "select g from Genre g")
)
public class Genre implements Serializable
{

    public static final String FIND_ALL = "Genre.findAll";

    @Id
    private String title;

    public Genre()
    {
    }

    public Genre(String title)
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
