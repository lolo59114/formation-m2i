package org.example.exercice6_voiture.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import org.example.exercice6_voiture.entity.Voiture;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VoitureService {
    List<Voiture> voitures;

    public VoitureService() {
        voitures = new ArrayList<>();
    }

    public List<Voiture> getAll() {
        return voitures;
    }


    public void add(Voiture voiture) {
        voitures.add(voiture);
    }

    public Voiture get(int id) {
        for (Voiture voiture : voitures) {
            if(voiture.getId() == id) {
                return voiture;
            }
        }
        return null;
    }

    public void update(Voiture voiture) {
        voitures.set(voitures.indexOf(voiture), voiture);
    }

    public boolean remove(int id) {
        Voiture voiture = voitures.get(id);
        if(voiture != null) {
            voitures.remove(voiture);
            return true;
        }
        return false;
    }
}
