package org.nemanjamarjanovic.rekomendator.bussines.content.boundary;

import java.io.File;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;

/**
 *
 * @author nemanja.marjanovic
 */
@Path("images")
@Loggable
public class ImageService
{

    @Inject
    private ServletContext servletContext;

    @GET
    @Path("users/{id}")
    public Response users(
            @NotNull
            @PathParam("id") final String id)
    {
        File file = new File(servletContext.getInitParameter("upload.location") + File.separator + "user" + File.separator + id);
        if (!file.exists()) {
            file = new File(ImageService.class.getClassLoader().getResource("icon/default_user.png").getFile());
        }

        return Response
                .status(Response.Status.OK)
                .entity((Object) file)
                .header("Content-Disposition", "attachment; filename=" + file.getName())
                .build();
    }

    @GET
    @Path("events/{id}")
    public Response events(
            @NotNull
            @PathParam("id") final String id)
    {
        File file = new File(servletContext.getInitParameter("upload.location") + File.separator + "event" + File.separator + id);
        
        return Response
                .status(Response.Status.OK)
                .entity((Object) file)
                .header("Content-Disposition", "attachment; filename=" + file.getName())
                .build();
    }

    @GET
    @Path("icons/{id}")
    public Response icons(
            @NotNull
            @PathParam("id") final String id)
    {

        File file = new File(ImageService.class.getClassLoader().getResource("icon/" + id.trim() + ".png").getFile());

        return Response
                .status(Response.Status.OK)
                .entity((Object) file)
                .header("Content-Disposition", "attachment; filename=" + file.getName())
                .build();
    }
}
