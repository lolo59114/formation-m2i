package org.example.exercice3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "tabPers", value = "/exercice3/tab-pers")
public class TabPersServlet extends HttpServlet {
    List<Personne> personnes;
    @Override
    public void init() throws ServletException {
        personnes = new ArrayList<>();
        personnes.add(new Personne("Loic", "VI", 31));
        personnes.add(new Personne("Loick", "Walles", 25));
        personnes.add(new Personne("Fatima", "Benajou", 28));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("personnes", personnes);
        req.getRequestDispatcher("tabPers.jsp").forward(req, resp);
    }
}
