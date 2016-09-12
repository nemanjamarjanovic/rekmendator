package org.nemanjamarjanovic.rekomendator.bussines.netflix.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nemanja
 */
@XmlRootElement
public class Rss {
    
    private Channel channel;

    public Rss() {
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
    
    
}
