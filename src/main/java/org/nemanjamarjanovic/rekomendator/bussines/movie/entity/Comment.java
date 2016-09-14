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
import static org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Comment.*;

/**
 *
 * @author nemanja
 */
@Entity
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = "select c from Comment c order by c.createdDate desc "),
    @NamedQuery(name = FIND_BY_USER, query = "select c from Comment c where c.user.id = :user "),
    @NamedQuery(name = FIND_BY_MOVIE, query = "select c from Comment c where c.movie.id = :movie ")
})
public class Comment implements Serializable {

    public static final String FIND_ALL = "Comment.findAll";
    public static final String FIND_BY_USER = "Comment.findByUser";
    public static final String FIND_BY_MOVIE = "Comment.findByMovie";
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @OneToOne
    private User user;

    @OneToOne
    private Movie movie;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    private String text;

    public Comment() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
