package org.example.tp_jee_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tp_jee_hopital.model.Patient;
import org.example.tp_jee_hopital.service.PatientService;
import org.example.tp_jee_hopital.util.HibernateSessionFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "patientServlet", value = "/hospital/patient/*")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class PatientServlet extends HttpServlet {
    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService(HibernateSessionFactory.getSessionFactory());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        HttpSession session = req.getSession();
        boolean logged = session.getAttribute("isLogged") != null && (boolean) session.getAttribute("isLogged");
        req.setAttribute("isLogged", logged);
        switch (action) {
            case "list" -> showAll(req, resp);
            case "add" -> addPatient(req,resp);
            case "details" -> showDetails(req, resp);
            default -> {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patients", patientService.getAllPatients());
        req.getRequestDispatcher("/patient/patientList.jsp").forward(req, resp);
    }

    private void addPatient(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        String pictureName = uploadPicture(req.getPart("picture"));
        patientService.createPatient(firstName, lastName, phoneNumber, dateOfBirth, pictureName);
        resp.sendRedirect("list");
    }

    protected void showDetails(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        long patientId = Long.parseLong(req.getParameter("id"));
        Patient patient= patientService.getPatient(patientId);
        req.setAttribute("patient",patient);
        req.getRequestDispatcher("/hospital/consultation/list").forward(req,resp);
    }

    private String uploadPicture(Part image) throws IOException {
        String uploadPath = getServletContext().getRealPath("/")+"image";
        File file = new File(uploadPath);
        if (!file.exists()){
            file.mkdir();
        }
        String fileName = image.getSubmittedFileName();
        image.write(uploadPath+File.separator+fileName);
        return fileName;
    }
}
