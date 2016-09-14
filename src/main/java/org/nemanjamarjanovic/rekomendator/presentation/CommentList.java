package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.CommentDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Comment;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class CommentList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CommentDao commentDao;

    private Pagination pagination;

    @PostConstruct
    public void init()
    {
        this.pagination = new Pagination(commentDao.findAll(), 20);
    }

    public List<Comment> movieComments(String movie)
    {
        return commentDao.findByMovie(movie);
    }

    public Pagination getPagination()
    {
        return pagination;
    }

    public void setPagination(Pagination pagination)
    {
        this.pagination = pagination;
    }
    
    
}
