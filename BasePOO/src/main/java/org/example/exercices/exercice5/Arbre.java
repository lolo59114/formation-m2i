package org.example.exercices.exercice5;

public class Arbre extends Plante{
    private double circonference;

    public Arbre(String nom, double hauteur, String couleur, double circonference) {
        super(nom, hauteur, couleur);
        this.circonference = circonference;
    }

    @Override
    public String toString() {
        return "Arbre{" +
                "nom='" + nom + '\'' +
                ", hauteur=" + hauteur +
                ", couleur='" + couleur + '\'' +
                ", circonference=" + circonference +
                '}';
    }
}
