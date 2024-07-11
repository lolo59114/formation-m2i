package org.example.exercice2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "bootstrap", urlPatterns = {"/exercice2/bootstrap-1","/exercice2/bootstrap-2"})
public class BootstrapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("/exercice2/bootstrap-1".equals(req.getServletPath())) {
            req.getRequestDispatcher("/exercice2/bootstrapPage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/exercice2/bootstrapPage2.jsp").forward(req, resp);
        }

    }
}
