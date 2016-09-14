package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.CommentDao;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class CommentEdit implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public String doCreate(String movie) {
        commentDao.create(movie, currentUser.getId(), this.text);
        return "movie-view?faces-redirect=true&id=" + movie;
    }

    public String doRemove(String comment) {
        commentDao.remove(comment);
        return "comment-list?faces-redirect=true";
    }

    public boolean isCommented(String movie) {
        return commentDao
                .findByUser(currentUser.getId())
                .parallelStream()
                .map(f -> f.getMovie().getId())
                .anyMatch(f -> (f.equals(movie)));
    }

}
