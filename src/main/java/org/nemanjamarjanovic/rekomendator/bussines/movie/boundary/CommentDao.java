package org.nemanjamarjanovic.rekomendator.bussines.movie.boundary;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Comment;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Movie;
import org.nemanjamarjanovic.rekomendator.bussines.security.entity.User;

/**
 *
 * @author nemanja
 */
@Stateless
public class CommentDao {

    @PersistenceContext
    EntityManager entityManager;

    public Comment findById(String id) {
        return entityManager.find(Comment.class, id);
    }

    public List<Comment> findByUser(String user) {
        return entityManager
                .createNamedQuery(Comment.FIND_BY_USER, Comment.class)
                .setParameter("user", user)
                .getResultList();
    }

    public List<Comment> findByMovie(String movie) {
        return entityManager
                .createNamedQuery(Comment.FIND_BY_MOVIE, Comment.class)
                .setParameter("movie", movie)
                .getResultList();
    }

    public void create(String movie, String user, String text) {
        Comment comment = new Comment();
        comment.setId(UUID.randomUUID().toString());
        comment.setCreatedDate(new Date());
        comment.setUser(entityManager.getReference(User.class, user));
        comment.setMovie(entityManager.getReference(Movie.class, movie));
        comment.setText(text);
        entityManager.persist(comment);
    }

}
