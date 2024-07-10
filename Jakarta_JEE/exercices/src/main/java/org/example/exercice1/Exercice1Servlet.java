package org.example.exercice1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "exercice1", value = "/exercice1")
public class Exercice1Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Bonjour ! Choisissez un lien !";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/exercice1/index.jsp").forward(request, response);
    }

}