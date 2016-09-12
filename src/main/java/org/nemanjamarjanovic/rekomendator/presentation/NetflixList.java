package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.netflix.boundary.NetflixRestClient;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class NetflixList implements Serializable {
    
    @Inject
    NetflixRestClient netflixRestClient;
    
    private Pagination pagination;
    
    @PostConstruct
    public void init() {
        
        this.pagination = new Pagination(
                netflixRestClient.getNetflixRssFeed().getChannel().getItems(),
                5);
    }
    
    public Pagination getPagination() {
        return pagination;
    }
 
}
