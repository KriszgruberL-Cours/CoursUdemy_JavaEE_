
package com.example.coursudemy_javaee_.ressources;


import com.example.coursudemy_javaee_.entities.Livre;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;


@Path("/livre")
public class LivreResource {

    private static List<Livre> catalogue = new ArrayList<>();

    static {
        Livre livre1 = new Livre(1, "Les miséroïdes" );
        Livre livre2 = new Livre(2,"Duel" );
        catalogue.add(livre1);
        catalogue.add(livre2);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livre> liste() {
        return catalogue;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{numero}")
    public Livre get(@PathParam("numero") int numero) {
        Livre livres=catalogue.stream()
                .filter(livre -> livre.getNumeroLivre() == numero)
                .findFirst()
                .get();

        return livres;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(@FormParam("nom") String nom) {
        Livre livre = new Livre();
        livre.setNumeroLivre(catalogue.size() + 1);
        livre.setNom(nom);
        catalogue.add(livre);

        return Response.status(Response.Status.CREATED)
                .entity(livre.getNumeroLivre())
                .build();
    }


    @DELETE
    @Path("/{numero}")
    public Response delete(@PathParam("numero") int numero) {
        catalogue.removeIf(livre -> livre.getNumeroLivre() == numero);

        return Response.status(Response.Status.OK)
                .build();
    }

    @PUT
    @Path("/{numero}")
    public Response modify(@PathParam("numero") int numero, @QueryParam("nom") String nom) {
        Livre livreAModifier = catalogue.stream()
                .filter(livre -> livre.getNumeroLivre() == numero)
                .findFirst()
                .get();
        livreAModifier.setNom(nom);

        return Response.status(Response.Status.OK)
                .build();
    }
}
