package org.nemanjamarjanovic.rekomendator.bussines.movie.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import static org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie.FIND_ALL;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries(
        @NamedQuery(name = FIND_ALL, query = "select m from Movie m")
)
public class Movie implements Serializable
{

    public static final String FIND_ALL = "Movie.findAll";

    @Id
    private UUID id;

    private String title;

    @OneToMany
    private Set<Genre> genre;

    @OneToMany
    private Set<Actor> actors;

    public Movie()
    {
    }

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
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
