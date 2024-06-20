package org.example.exercices.exercice1;

public class Chaise {
    private int nbPieds = 4;
    private String materiaux = "bois";
    private String couleur = "marron";
    private double prix;

    public Chaise() {}

    public Chaise(int nbPieds, String materiaux, String couleur, double prix) {
        this.nbPieds = nbPieds;
        this.materiaux = materiaux;
        this.couleur = couleur;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Je suis une chaise avec " +
                nbPieds + " pied(s)" +
                " en " + materiaux  +
                " de couleur " + couleur +
                " à un prix de " + prix;
    }
}
