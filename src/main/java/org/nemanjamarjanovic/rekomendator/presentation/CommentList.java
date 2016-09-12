package org.nemanjamarjanovic.rekomendator.presentation;

import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.CommentDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Comment;

/**
 *
 * @author nemanja
 */
@Model
public class CommentList {

    @Inject
    private CommentDao commentDao;

    public List<Comment> movieComments(String movie) {
        return commentDao.findByMovie(movie);
    }
}
