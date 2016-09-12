package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.CommentDao;

/**
 *
 * @author nemanja
 */
@Model
public class CommentEdit implements Serializable {

    @Inject
    private CommentDao commentDao;

    @Inject
    private CurrentUser currentUser;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String doComment(String movie) {
        commentDao.create(movie, currentUser.getId(), this.text);
        return "movie-view?faces-redirect=true&id=" + movie;
    }

    public boolean isCommented(String movie) {
        return commentDao
                .findByUser(currentUser.getId())
                .parallelStream()
                .map(f -> f.getMovie().getId())
                .anyMatch(f -> (f.equals(movie)));
    }

}
