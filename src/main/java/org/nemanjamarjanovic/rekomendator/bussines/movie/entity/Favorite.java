package org.nemanjamarjanovic.rekomendator.bussines.movie.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import static org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Favorite.FIND_ALL;
import org.nemanjamarjanovic.rekomendator.bussines.user.entity.User;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries(
        @NamedQuery(name = FIND_ALL, query = "select f from Favorite f")
)
public class Favorite implements Serializable
{

    public static final String FIND_ALL = "Favorite.findAll";

    @Id
    private String id;

    @OneToOne
    private User user;

    @OneToOne
    private Movie movie;

    private Date createdDate;

    public Favorite()
    {
    }

    public Favorite(String id, User user, Movie movie)
    {
        this.id = UUID.randomUUID().toString();
        this.createdDate = new Date();
        this.user = user;
        this.movie = movie;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

}
