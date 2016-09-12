package org.nemanjamarjanovic.rekomendator.bussines.content.boundary;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author nemanja
 */
@WebServlet(name = "Uploader", urlPatterns = {"/faces/pages/uploader"})
@MultipartConfig
public class Uploader extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Part filePart = request.getPart("file");

         String location = request.getServletContext().getInitParameter("upload.location") + File.separator + "trailer"+id;
        Path path = FileSystems.getDefault().getPath(location);
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, path, StandardCopyOption.REPLACE_EXISTING);
        }

        System.out.println("Uploaded file successfully saved in " + path);
        response.sendRedirect("movie-edit.xhtml?id=" + id);
    }
}
