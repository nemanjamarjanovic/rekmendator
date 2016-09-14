package org.nemanjamarjanovic.rekomendator.bussines.movie.entity;

import org.nemanjamarjanovic.rekomendator.bussines.security.entity.User;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import static org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Rate.*;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries({
    @NamedQuery(name = FIND_BY_USER, 
            query = "select r from Rate r where r.user.id = :user "),
    @NamedQuery(name = FIND_TOP_MOVIES, 
            query = "select r.movie, avg(r.value) from Rate r "
                    + " group by (r.movie) order by avg(r.value) desc"),
    @NamedQuery(name = FIND_AVERAGE_BY_MOVIE, 
            query = "select avg(r.value) from Rate r "
                    + "where r.movie.id = :movie group by (r.movie.id) "
                    + "order by avg(r.value) desc ")
})
public class Rate implements Serializable {

    public static final String FIND_BY_USER = "Rate.findByUser";
    public static final String FIND_AVERAGE_BY_MOVIE = "Rate.findAverageByMovie";
    public static final String FIND_TOP_MOVIES = "Rate.findTopMovies";
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @OneToOne
    private User user;

    @OneToOne
    private Movie movie;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    private int value;

    public Rate() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rate other = (Rate) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
