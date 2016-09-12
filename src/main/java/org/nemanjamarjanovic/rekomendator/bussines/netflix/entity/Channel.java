package org.nemanjamarjanovic.rekomendator.bussines.netflix.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author nemanja
 */
@XmlType(propOrder={"title", "items"})
public class Channel {

    private String title;
    private List<Item> items;

    public Channel() {
    }

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
