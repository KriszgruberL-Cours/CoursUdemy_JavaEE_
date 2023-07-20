package com.example.coursudemy_javaee_.servlets;

import java.io.*;

import com.example.coursudemy_javaee_.entities.Person;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Person m = new Person("Michel", "Dupont");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<h1>" +"Bonjour " +  request.getSession().getAttribute("login") + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}