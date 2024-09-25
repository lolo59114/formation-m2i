package org.example.tp_jee_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.tp_jee_hopital.exception.NoEntityFoundException;
import org.example.tp_jee_hopital.model.Consultation;
import org.example.tp_jee_hopital.model.Patient;
import org.example.tp_jee_hopital.service.ConsultationService;
import org.example.tp_jee_hopital.service.PatientService;
import org.example.tp_jee_hopital.util.HibernateSession;

import java.io.IOException;

@WebServlet(name = "consultationServlet", value = "/hospital/consultation/*")
public class ConsultationServlet extends HttpServlet {
    private ConsultationService consultationService;
    private PatientService patientService;

    @Override
    public void init() {
        consultationService = new ConsultationService(HibernateSession.getInstance().getSessionFactory());
        patientService = new PatientService(HibernateSession.getInstance().getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        HttpSession session = req.getSession();
        boolean logged = session.getAttribute("isLogged") != null && (boolean) session.getAttribute("isLogged");
        req.setAttribute("isLogged", logged);
        switch (action) {
            case "add" -> addConsultation(req,resp);
            case "details" -> showDetails(req, resp);
            default -> {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        switch (action) {
            case "updateCareSheet" -> updateCareSheet(req,resp);
            case "updatePrescription" -> updatePrescription(req, resp);
        }
        doGet(req,resp);
    }

    private void addConsultation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idPatient = Long.parseLong(req.getParameter("idPatient"));
        Patient patient = patientService.getPatient(idPatient);
        Consultation consultation = consultationService.createEmptyConsultation(patient);
        req.setAttribute("consultation", consultation);
        req.getRequestDispatcher("/consultation/consultationDetails.jsp").forward(req, resp);
    }

    private void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long consultationId = Long.parseLong(req.getParameter("id"));
        Consultation consultation = consultationService.getConsultation(consultationId);
        if (consultation == null) {
            noEntityFound(req);
        }
        req.setAttribute("consultation", consultation);
        req.getRequestDispatcher("/consultation/consultationDetails.jsp").forward(req, resp);
    }

    private void updateCareSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String careSheet = req.getParameter("careSheet");
        Consultation consultation = consultationService.getConsultation(Long.parseLong(req.getParameter("idConsultation")));
        if (consultation != null) {
            if (careSheet != null && !careSheet.isEmpty()) {
                consultation.setCareSheet(careSheet);
                consultationService.updateConsultation(consultation);
            }
        } else {
            noEntityFound(req);
        }

        req.setAttribute("consultation", consultation);
        req.getRequestDispatcher("/consultation/consultationDetails.jsp").forward(req, resp);
    }

    private void updatePrescription(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prescription = req.getParameter("prescription");
        Consultation consultation = consultationService.getConsultation(Long.parseLong(req.getParameter("idConsultation")));
        if (consultation != null) {
            if (prescription != null && !prescription.isEmpty()) {
                consultation.setPrescription(prescription);
                consultationService.updateConsultation(consultation);
            }
        } else {
            noEntityFound(req);
        }

        req.setAttribute("consultation", consultation);
        req.getRequestDispatcher("/consultation/consultationDetails.jsp").forward(req, resp);
    }

    private void noEntityFound(HttpServletRequest req) {
        req.setAttribute("errorName", "La consultation n'a pas été trouvée");
        req.setAttribute("message", "Désolé, nous n'avons pas réussi à retrouver la consultation");
        throw new NoEntityFoundException();
    }

}
