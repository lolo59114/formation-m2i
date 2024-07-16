package org.example.tp_jee_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "connectionServlet", value = "/hospital/connection")
public class ConnectionServlet extends HttpServlet {
    private final String LOGIN = "Lolow";
    private final String PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/connection/connection.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if((req.getParameter("login") != null && req.getParameter("login").equals(LOGIN))
                && (req.getParameter("password") != null && req.getParameter("password").equals(PASSWORD))){
            HttpSession session = req.getSession();
            session.setAttribute("isLogged",true);
            resp.sendRedirect("patient/list");
        } else {
            req.setAttribute("loginError","Le couple login / mot de passe est incorrect.");
            doGet(req, resp);
        }
    }
}
