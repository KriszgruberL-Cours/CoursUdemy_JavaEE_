package com.example.coursudemy_javaee_.servlets;

import com.example.coursudemy_javaee_.entities.Catalogue;
import com.example.coursudemy_javaee_.entities.ShoppingCart;
import com.example.coursudemy_javaee_.entities.Work;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "addToCart", value = "/addToCart")
public class AddToCartServlet extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        Long id = Long.parseLong(idString);

        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new ShoppingCart();
            request.getSession().setAttribute("cart",cart);
        }

        Optional<Work> work = Catalogue.listOfWork.stream()
                .filter(w -> w.getId() == id)
                .findAny();

        if(work.isPresent()){
            cart.getItems().add(work.get());
        }

        PrintWriter out = response.getWriter();

        out.println("""
                <html><body>
                <h2>Oeuvre ajouté au caddie</h2>
                <a href="catalogue">Retourner au catalogue</a>
                <a href="index.jsp">Retourner a l'accueil</a>
                </body></html>
                """);
    }

    @Override
    public void destroy() {

    }
}