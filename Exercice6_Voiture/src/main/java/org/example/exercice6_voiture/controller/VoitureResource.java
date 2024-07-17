package org.example.exercice6_voiture.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice6_voiture.entity.Voiture;
import org.example.exercice6_voiture.service.VoitureService;

@Path("/voiture")
public class VoitureResource {
    private final VoitureService voitureService;

    @Inject
    public VoitureResource(VoitureService voitureService) {
        this.voitureService = new VoitureService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllVoitures() {
        return voitureService.getAll().toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Voiture addVoiture(Voiture voiture) {
        voitureService.add(voiture);
        return voiture;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Voiture getVoiture(@PathParam("id") int id) {
        return voitureService.get(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
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