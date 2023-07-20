package com.example.coursudemy_javaee_.servlets;

import com.example.coursudemy_javaee_.entities.Artist;
import com.example.coursudemy_javaee_.entities.Catalogue;
import com.example.coursudemy_javaee_.entities.Work;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addWork", value = "/addWork")
public class AddWorkServlet extends HttpServlet {

    @Override
    public void init() {

    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String title = request.getParameter("title");
            String releaseString = request.getParameter("release");
            String gender = request.getParameter("gender");
            String artist = request.getParameter("artist");
            String summary = request.getParameter("summary");

            Integer release = 0;
            boolean success = true;

            Work newWork = new Work(Work.incrementId(), title, gender, release, summary, new Artist(artist));

            try {
            release = Integer.parseInt(releaseString);
            newWork.setRelease(release);
            } catch (NumberFormatException nfe){
                success = false;
            }

            for (Work work : Catalogue.listOfWork){
                if(work.getTitle().equals(newWork.getTitle())){
                    success = false;
                };
            }

            if(success){
                Catalogue.listOfWork.add(newWork);
                request.setAttribute("id", newWork.getId());
                request.getRequestDispatcher("/success").forward(request, response);
            }else {
            RequestDispatcher dis = request.getRequestDispatcher("/error");
            dis.forward(request, response);
        }


//        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    public void destroy() {

    }
}