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
@Path("videos")
@Loggable
public class VideoService
{

    @Inject
    private ServletContext servletContext;

    @GET
    @Path("{id}")
    public Response download(
            @NotNull
            @PathParam("id") final String id)
    {
        File file = new File(servletContext.getInitParameter("upload.location") + File.separator + "video" + File.separator + id);
        return Response
                .status(Response.Status.OK)
                .entity((Object) file)
                .header("Content-Disposition", "attachment; filename=" + file.getName())
                .build();
    }
}
