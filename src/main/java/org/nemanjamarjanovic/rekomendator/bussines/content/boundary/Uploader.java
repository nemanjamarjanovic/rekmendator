package org.nemanjamarjanovic.rekomendator.bussines.content.boundary;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.MovieDao;

/**
 *
 * @author nemanja
 */
@WebServlet(name = "Uploader", urlPatterns = {"/faces/pages/uploader"})
@MultipartConfig
public class Uploader extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    @Inject
    private MovieDao movieDao;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        String id = request.getParameter("id");
        Part filePart = request.getPart("file");
        String location = request.getServletContext().getInitParameter("upload.location") + File.separator + "videos" + id;
        
        Path path = FileSystems.getDefault().getPath(location);
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, path, StandardCopyOption.REPLACE_EXISTING);
        }
        
        movieDao.trailerUploaded(id);
        response.sendRedirect("movie-edit.xhtml?id=" + id);
    }
}
