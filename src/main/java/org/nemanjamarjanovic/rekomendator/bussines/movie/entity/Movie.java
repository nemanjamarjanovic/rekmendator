package org.nemanjamarjanovic.rekomendator.bussines.movie.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import static org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie.*;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = "select m from Movie m"),
    @NamedQuery(name = SEARCH, query = "select m from Movie m  "
            + " where( :title is null or (:title is not null and m.title like :title)) ")
           // + "  and ( :publishingDate is null or (:publishingDate is not null and m.publishingDate between :from and :to )) ")
})
@XmlRootElement
public class Movie implements Serializable
{

    public static final String FIND_ALL = "Movie.findAll";
    public static final String SEARCH = "Movie.Search";

    @Id
    private String id;
    private String title;
    private String description;
    private Integer duration;
    private String youtube;
    private boolean trailer;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getYoutube()
    {
        return youtube;
    }

    public void setYoutube(String youtube)
    {
        this.youtube = youtube;
    }

    public boolean isTrailer()
    {
        return trailer;
    }

    public void setTrailer(boolean trailer)
    {
        this.trailer = trailer;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

}
