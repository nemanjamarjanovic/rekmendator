package org.nemanjamarjanovic.rekomendator.bussines.actor.boundary;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author nemanja.marjanovic
 */
@ApplicationScoped
public class ActorServiceClient
{

    private ActorService port;

    @PostConstruct
    public void init()
    {
        this.port = new ActorService_Service().getActorServicePort();
    }

    public String search(String name)
    {
        return this.port.search(name);
    }

    public void add(String name)
    {
        this.port.add(name);
    }

}
