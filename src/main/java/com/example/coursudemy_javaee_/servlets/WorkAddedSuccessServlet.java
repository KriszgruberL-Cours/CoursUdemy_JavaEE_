package com.example.coursudemy_javaee_.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "success", value = "/success")
public class WorkAddedSuccessServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
        response.setContentType("text/html");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Unexpected WorkAddedSuccessServlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Work added, it's id is : "+ request.getAttribute("id")+" </h1>");
            out.println("<h1> <a href=\"catalogue\">Return to catalogue</a> </h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void destroy() {

    }
}