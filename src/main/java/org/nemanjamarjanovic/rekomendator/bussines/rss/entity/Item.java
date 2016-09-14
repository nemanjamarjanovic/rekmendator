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
    private Double rating;

    public Item()
    {
    }

    public Item(String title, String description, String link, Double rating)
    {
        this.title = title;
        this.description = description;
        this.link = link;
        this.link = link;
        this.rating = rating;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

}
