package org.example.exercice6_voiture.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice6_voiture.entity.Voiture;
import org.example.exercice6_voiture.service.VoitureService;

import java.util.ArrayList;
import java.util.List;


@Path("/voiture")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoitureResource {
    private final VoitureService voitureService;

    @Inject
    public VoitureResource(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @GET
    public List<Voiture> getAllVoitures() {
        if (voitureService.getAll().isEmpty()) {
            return new ArrayList<>();
        }
        return voitureService.getAll();
    }

    @POST
    @Path("/add")
    public Voiture addVoiture(Voiture voiture) {
        voitureService.add(voiture);
        return voiture;
    }

    @GET
    @Path("{id}")
    public Voiture getVoiture(@PathParam("id") int id) {
        return voitureService.getById(id);
    }

    @PUT
    @Path("/update")
    public Voiture updateVoiture(Voiture voiture) {
        voitureService.update(voiture);
        return voiture;
    }

    @DELETE
    @Path("{id}")
    public Boolean deleteVoiture(@PathParam("id") int id) {
        return voitureService.remove(id);
    }
}