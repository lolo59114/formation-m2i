package org.example.exercicesPOO.exercice5;

public class Plante {
    protected String nom;
    protected double hauteur;
    protected String couleur;

    public Plante(String nom, double hauteur, String couleur) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "nom='" + nom + '\'' +
                ", hauteur=" + hauteur +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
