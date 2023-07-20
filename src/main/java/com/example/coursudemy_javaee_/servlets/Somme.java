package com.example.coursudemy_javaee_.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "somme", value = "/somme")
public class Somme extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        try {
            int somme = Integer.parseInt(n1) + Integer.parseInt(n2);
            out.println("<html><body>");
            out.println("<h1>" +"La somme des deux nombres fourni est " + somme+  "</h1>");
            out.println("</body></html>");
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