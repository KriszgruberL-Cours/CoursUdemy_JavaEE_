package com.example.coursudemy_javaee_.servlets;

import com.example.coursudemy_javaee_.entities.Artist;
import com.example.coursudemy_javaee_.entities.Catalogue;
import com.example.coursudemy_javaee_.entities.Work;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

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

        String login = request.getParameter("log").trim();
        String pwd = request.getParameter("pwd").trim();
        System.out.println(login);

        if (login.equals("michel") && pwd.equals("123456") || login.equals("caroline") && pwd.equals("abcdef") ){
            out.println("""
                <html><body>
                <h2>Logged with succes!</h2>
                <a href="index.jsp">Home</a>
                </body></html>
                """);
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}