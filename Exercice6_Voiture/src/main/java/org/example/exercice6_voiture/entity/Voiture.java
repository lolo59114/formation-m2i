package org.example.exercice6_voiture.entity;

import org.example.exercice6_voiture.util.CouleurEnum;

public class Voiture {
    private int id;
    private static int nbVoitures = 0;
    private String marque;
    private int anneeFabrication;
    private CouleurEnum couleur;

    public Voiture(String marque, int anneeFabrication, CouleurEnum couleur) {
        this.id = nbVoitures++;
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
        this.couleur = couleur;
    }

    public Voiture() {
        this.id = nbVoitures++;
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
