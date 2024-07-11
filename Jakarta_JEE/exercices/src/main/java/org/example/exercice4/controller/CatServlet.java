package org.example.exercice4.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice4.model.Cat;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/exercice4/cat")
public class CatServlet extends HttpServlet {
    private List<Cat> cats;

    @Override
    public void init() throws ServletException {
        cats = new ArrayList<>();
//        cats.add(new Cat("Felix", "Chat", "Croquettes", LocalDate.now()));
//        cats.add(new Cat("Michel", "Humaine", "Poissons", LocalDate.now()));
//        cats.add(new Cat("Sphinx", "Statue", "????", LocalDate.now()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cats", cats);
        req.getRequestDispatcher("cat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat newCat = new Cat(req.getParameter("name"), req.getParameter("race"), req.getParameter("favorite-meal"), LocalDate.parse(req.getParameter("birthday")));
        cats.add(newCat);
        req.setAttribute("cats", cats);
        req.getRequestDispatcher("cat.jsp").forward(req, resp);
    }
}
