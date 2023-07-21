package com.example.coursudemy_javaee_.servlets;

import com.example.coursudemy_javaee_.entities.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static com.example.coursudemy_javaee_.entities.Work.incrementId;

@WebServlet(name = "catalogue", value = "/catalogue")
public class CatalogueServlet extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (Catalogue.listOfWork.isEmpty()) {
            Work mr = new Work(incrementId(), "Minority Report", "Science Fiction", 2002, "A future technology makes it possible for police officers to catch criminals before a crime is committed. John Anderton is accused of one such crime and sets out to prove his innocence.", new Artist("Tom Cruise"));
            Work bad = new Work(incrementId(), "Bad", "Pop", 1987, "Bad is the seventh studio album by the American singer and songwriter Michael Jackson.", new Artist("Michael Jackson"));
            Work gendarme = new Work(incrementId(), "Le Gendarme de Saint-Tropez", "Comédie", 1964, "A French police officer's daughter tries to pass herself off as a wealthy heiress.", new Artist("Louis de Funès"));

            Catalogue.listOfWork.add(mr);
            Catalogue.listOfWork.add(bad);
            Catalogue.listOfWork.add(gendarme);
        }

//        request.setAttribute("catalogueList", Catalogue.listOfWork);
//        RequestDispatcher dis = request.getRequestDispatcher("/catalogue.jsp");
//        dis.forward(request,response);

        ObjectMapper om = new ObjectMapper();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        om.writeValue(out, Catalogue.listOfWork);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}