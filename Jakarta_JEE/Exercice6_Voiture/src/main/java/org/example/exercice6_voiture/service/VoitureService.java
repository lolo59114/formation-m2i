package org.example.exercice6_voiture.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exercice6_voiture.entity.Voiture;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VoitureService {
    List<Voiture> voitures= new ArrayList<>();

    public List<Voiture> getAll() {
        System.out.println(voitures.size());
        return voitures;
    }


    public void add(Voiture voiture) {
        System.out.println(voiture);
        voitures.add(voiture);
    }

    public Voiture getById(int id) {
        for (Voiture voiture : voitures) {
            if(voiture.getId() == id) {
                return voiture;
            }
        }
        return null;
    }

    public void update(Voiture voiture) {
        Voiture voiture1 = getById(voiture.getId());
        voitures.set(voitures.indexOf(voiture1), voiture);
    }

    public boolean remove(int id) {
        Voiture voiture = this.getById(id);
        if(voiture != null) {
            voitures.remove(voiture);
            return true;
        }
        return false;
    }
}
