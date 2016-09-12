package org.nemanjamarjanovic.rekomendator.bussines.netflix.entity;

import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nemanja
 */
public class Item {

    private String title;
    private String link;
    private String description;

    @XmlTransient
    private String image;
    @XmlTransient
    private String sinopsis;

    public Item() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        String[] split = description.split("\"");
        this.image = "http:" + split[3];
        this.sinopsis = split[4].substring(10);

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

}
