package com.example.coursudemy_javaee_.servlets;

import com.example.coursudemy_javaee_.entities.Catalogue;
import com.example.coursudemy_javaee_.entities.Work;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "details", value = "/details")
public class WorkDetailsServlet extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String param = request.getParameter("id");

        Work work = Catalogue.listOfWork.stream()
                .filter(w -> w.getId() == Long.parseLong(param))
                .findFirst()
                .get();


        out.println("<html><body><ul>");
        out.println(" <li>Title : "+ work.getTitle() + "</li> ");
        out.println(" <li>Release : "+ work.getRelease() + "</li> ");
        out.println(" <li>Gender : "+ work.getGender() + "</li> ");
        out.println(" <li>Artist : "+ work.getMainArtist().getName() + "</li> ");
        out.println(" <li>Summary : "+ work.getSummary() + "</li> ");

        out.println("</ul></body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}