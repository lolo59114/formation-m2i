package org.example.exercice6_voiture.entity;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exercice6_voiture.util.CouleurEnum;

@ApplicationScoped
public class Voiture {
    private int id;
    private String marque;
    private int anneeFabrication;
    private CouleurEnum couleur;

    public Voiture(int id, String marque, int anneeFabrication, CouleurEnum couleur) {
        this.id = id;
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
        this.couleur = couleur;
    }

    public Voiture() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(int anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public CouleurEnum getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurEnum couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", anneeFabrication=" + anneeFabrication +
                ", couleur=" + couleur +
                '}';
    }
}
