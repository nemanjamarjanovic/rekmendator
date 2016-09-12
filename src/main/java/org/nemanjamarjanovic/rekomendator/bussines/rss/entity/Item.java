package org.nemanjamarjanovic.rekomendator.bussines.rss.entity;

/**
 *
 * @author nemanja
 */
public class Item
{

    private String title;
    private String description;
    private String link;

    public Item()
    {
    }

    public Item(String title, String description, String link)
    {
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
