package com.example.coursudemy_javaee_.ressources;

import com.example.coursudemy_javaee_.entities.Artist;
import com.example.coursudemy_javaee_.entities.Catalogue;
import com.example.coursudemy_javaee_.entities.Work;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Set;

import static com.example.coursudemy_javaee_.entities.Work.incrementId;

@Path(("/catalogue"))
public class CatalogueRessource {

    @GET
    @Path("/liste")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Work> liste(){

        if (Catalogue.listOfWork.isEmpty()) {
            Work mr = new Work(incrementId(), "Minority Report", "Science Fiction", 2002, "A future technology makes it possible for police officers to catch criminals before a crime is committed. John Anderton is accused of one such crime and sets out to prove his innocence.", new Artist("Tom Cruise"));
            Work bad = new Work(incrementId(), "Bad", "Pop", 1987, "Bad is the seventh studio album by the American singer and songwriter Michael Jackson.", new Artist("Michael Jackson"));
            Work gendarme = new Work(incrementId(), "Le Gendarme de Saint-Tropez", "Comédie", 1964, "A French police officer's daughter tries to pass herself off as a wealthy heiress.", new Artist("Louis de Funès"));

            Catalogue.listOfWork.add(mr);
            Catalogue.listOfWork.add(bad);
            Catalogue.listOfWork.add(gendarme);
        }

        return Catalogue.listOfWork;
    }

    @POST
    public Response ajout(@FormParam("title") String title, @FormParam("gender") String gender, @FormParam("release") int release, @FormParam("summary") String summary, @FormParam("artist") String artist) {

        boolean success = true;

        Work nouvelleOeuvre = new Work(title);
        nouvelleOeuvre.setGender(gender);
        try {
            nouvelleOeuvre.setRelease(release);
        } catch (NumberFormatException nfe) {
            success = false;
        }
        nouvelleOeuvre.setSummary(summary);
        nouvelleOeuvre.setMainArtist(new Artist(artist));

        Catalogue.listOfWork.add(nouvelleOeuvre);

        return Response.status(Response.Status.CREATED).build();
    }
}
