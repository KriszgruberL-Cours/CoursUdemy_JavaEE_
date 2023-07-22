package com.example.coursudemy_javaee_.ressources;


import com.example.coursudemy_javaee_.entities.Produit;
import com.example.coursudemy_javaee_.entities.Somme;
import com.example.coursudemy_javaee_.entities.SommeEtProduit;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/calculation")
public class CalculationRessource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/somme-et-produit")
    public SommeEtProduit sommeEtProduit(@QueryParam("n1") Integer n1, @QueryParam("n2") Integer n2){
        int sommeNumerique = n1 + n2;
        int produitNumerique = n1 * n2;

        Somme somme = new Somme(sommeNumerique, "douze");
        Produit produit = new Produit(produitNumerique, "trente-six");

        return new SommeEtProduit(somme, produit);
    }
}
