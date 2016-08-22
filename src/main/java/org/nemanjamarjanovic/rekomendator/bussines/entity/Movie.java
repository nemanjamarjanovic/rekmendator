package org.nemanjamarjanovic.rekomendator.bussines.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static org.nemanjamarjanovic.rekomendator.bussines.entity.Movie.*;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = "select m from Movie m"),
    @NamedQuery(name = FIND_BY_TITLE, query = "select m from Movie m where m.title like :title ")
})
public class Movie implements Serializable
{

    public static final String FIND_ALL = "Movie.findAll";
    public static final String FIND_BY_TITLE = "Movie.findByTitle";

    @Id
    private String id;
    private String title;
    private String description;
    private Integer duration;

    @Temporal(TemporalType.DATE)
    private Date publishingDate;

    @OneToMany
    private Set<Genre> genre;

    @OneToMany
    private Set<Actor> actors;

    public Movie()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Set<Genre> getGenre()
    {
        return genre;
    }

    public void setGenre(Set<Genre> genre)
    {
        this.genre = genre;
    }

    public Set<Actor> getActors()
    {
        return actors;
    }

    public void setActors(Set<Actor> actors)
    {
        this.actors = actors;
    }

}
