package org.nemanjamarjanovic.rekomendator.bussines.security.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static org.nemanjamarjanovic.rekomendator.bussines.security.entity.Page.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries(
        @NamedQuery(name = FIND_ALL, query = "select p from Page p")
)
public class Page implements Serializable
{

    public static final String FIND_ALL = "Page.findAll";
    private static final long serialVersionUID = 1L;

    @Id
    private String title;
    private String page;

    public Page()
    {
    }

    public Page(String title)
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

    public String getPage()
    {
        return page;
    }

    public void setPage(String page)
    {
        this.page = page;
    }

}
