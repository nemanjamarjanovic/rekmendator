package org.nemanjamarjanovic.rekomendator.presentation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.EventDao;
import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Event;

/**
 *
 * @author nemanja
 */
@Named
@ViewScoped
public class EventEdit implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Inject
    private EventDao eventDao;

    @Inject
    ServletContext servletContext;
    
    private Event data = new Event();
    private List<String> eventImages;

    public String doCreate() {
        eventDao.create(data);
        return "event-list?faces-redirect=true";
    }

    public String doApprove(String event) {
        eventDao.approve(event);
        return "event-list?faces-redirect=true";
    }

    public void doSaveImage(ValueChangeEvent event) {
        Part file = (Part) event.getNewValue();

        try (InputStream input = file.getInputStream()) {
            Files.copy(input,
                    new File(servletContext.getInitParameter("upload.location")
                            + File.separator + "event",
                            this.data.getId() + "-" + UUID.randomUUID().toString())
                    .toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public Event getData() {
        return data;
    }

    public void setData(Event data) {
        this.data = data;
    }

    public List<String> getEventImages() throws IOException
    {
        this.eventImages = new ArrayList<>();
        Files.newDirectoryStream(
                Paths.get(servletContext.getInitParameter("upload.location") + File.separator + "event"))
                .forEach(
                        f -> this.eventImages.add(f.getFileName().toString())
                );

        return this.eventImages;

    }

    public void setEventImages(List<String> eventImages)
    {
        this.eventImages = eventImages;
    }

}
