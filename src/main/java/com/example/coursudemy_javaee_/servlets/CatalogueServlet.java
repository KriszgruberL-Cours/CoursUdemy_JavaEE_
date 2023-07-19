package com.example.coursudemy_javaee_.servlets;

import com.example.coursudemy_javaee_.entities.Artist;
import com.example.coursudemy_javaee_.entities.Catalogue;
import com.example.coursudemy_javaee_.entities.Person;
import com.example.coursudemy_javaee_.entities.Work;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "catalogue", value = "/catalogue")
public class CatalogueServlet extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Catalogue.listOfWork.isEmpty()){
            Work mr = new Work(1L,"Minority Report", "Science Fiction", 2002, "A future technology makes it possible for police officers to catch criminals before a crime is committed. John Anderton is accused of one such crime and sets out to prove his innocence.", new Artist("Tom Cruise"));
            Work bad = new Work(2L,"Bad", "Pop", 1987, "Bad is the seventh studio album by the American singer and songwriter Michael Jackson.", new Artist("Michael Jackson"));
            Work gendarme = new Work(3L,"Le Gendarme de Saint-Tropez", "Comédie", 1964, "A French police officer's daughter tries to pass herself off as a wealthy heiress.", new Artist("Louis de Funès"));

            Catalogue.listOfWork.add(mr);
            Catalogue.listOfWork.add(bad);
            Catalogue.listOfWork.add(gendarme);

        }
        response.setContentType("text/html; charset=UTF-8 ");


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello from the Servlet</h1>");
        for (Work work : Catalogue.listOfWork) {
            String link = "/details?id=" + work.getId();
            out.printf("<p><a href=\"%s\">%s (%s)</a></p>%n", link, work.getTitle(), work.getRelease());
        }

        out.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}