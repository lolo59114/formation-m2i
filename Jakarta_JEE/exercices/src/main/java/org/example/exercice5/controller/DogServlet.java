package org.example.exercice5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice5.model.Dog;
import org.example.exercice5.repository.DogRepository;
import org.example.exercice5.service.DogService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "dogServlet", value = {"/exercice5/dog/list", "/exercice5/dog/add", "/exercice5/dog/details/*"})
public class DogServlet extends HttpServlet {
    private DogService dogService;


    @Override
    public void init() {
        dogService = new DogService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspUrl = "/exercice5/index.jsp";

        switch (req.getServletPath()) {
            case "/exercice5/dog/add" -> {
                req.setAttribute("title", "Add a Dog");
                jspUrl = "/exercice5/add.jsp";
            }
            case "/exercice5/dog/details" -> {
                getDetails(req);
                jspUrl = "/exercice5/add.jsp";
            }
            default -> {
                req.setAttribute("dogs", dogService.getAll());
            }
        }
        req.getRequestDispatcher(jspUrl).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate birthDate = req.getParameter("birthdate").isEmpty() ? LocalDate.now() : LocalDate.parse(req.getParameter("birthdate"));
        dogService.save(name, breed, birthDate);
        resp.sendRedirect(req.getContextPath()+"/exercice5/dog/list");
    }

    private void getDetails(HttpServletRequest req) {
        String pathInfo = (req.getPathInfo() != null && !req.getPathInfo().isEmpty()) ? req.getPathInfo() : "";
        req.setAttribute("title", "View a Dog");
        req.setAttribute("readOnly", "readonly");
        if(!pathInfo.isEmpty()){
            try {
                int id = Integer.parseInt(pathInfo.substring(1));
                req.setAttribute("id", id);
                Dog dog = dogService.getById(id);
                if(dog == null){
                    req.setAttribute("isNotFound", true);
                }
                req.setAttribute("dog", dog);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                req.setAttribute("errorMessage", e.getMessage());
            }
        }
    }
}
