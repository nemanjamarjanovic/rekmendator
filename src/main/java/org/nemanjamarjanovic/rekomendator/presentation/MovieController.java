package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author nemanja.marjanovic
 */
@Named
@ConversationScoped
public class MovieController implements Serializable
{

    private String title = "";
    private List<String> movies = new ArrayList<>();

    @Inject
    Conversation conversation;

    @PostConstruct
    public void init()
    {
        //conversation.end();
        conversation.begin();
    }

    public void search()
    {
        if (movies.isEmpty()) {
            conversation.end();
            conversation.begin();
            movies.clear();
            movies.add("Prvi");
            movies.add("Drugi");
            movies.add("Treci");
            movies.add("Cetvrti");
            movies.add("Peti");
            FacesContext.getCurrentInstance().addMessage("test", new FacesMessage("New movies!"));
        }
        else {
            movies.remove(0);
        }
    }

    public List<String> getMovies()
    {
        return movies;
    }

    public void setMovies(List<String> movies)
    {
        this.movies = movies;
    }

}
