package com.example.coursudemy_javaee_.servlets;

import com.example.coursudemy_javaee_.entities.Produit;
import com.example.coursudemy_javaee_.entities.Somme;
import com.example.coursudemy_javaee_.entities.SommeEtProduit;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "somme", value = "/somme")
public class SommeServlet extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        try {
            int sommeNumerique = Integer.parseInt(n1) + Integer.parseInt(n2);
            int produitNumerique = Integer.parseInt(n1) * Integer.parseInt(n2);
            request.setAttribute("somme", sommeNumerique);
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            ObjectMapper om = new ObjectMapper();

            Somme somme = new Somme(sommeNumerique, "douze");
            Produit produit = new Produit(produitNumerique, "trente-six");
            SommeEtProduit sommeEtProduit = new SommeEtProduit(somme, produit);

            om.writeValue(out, sommeEtProduit);

//            String message = "{\"somme\" : {\"numerique\" : "+ somme +" , \"texte\" : \"douze\"},\"produit\" : {\"numerique\" : "+ produit +" , \"texte\" : \"trente-six\"}}";

//            out.println(message);

        } catch (NumberFormatException nfe){
            RequestDispatcher dis = request.getRequestDispatcher("/error");
            dis.forward(request,response);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}