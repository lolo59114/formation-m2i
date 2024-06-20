package org.example.exercices.exercice3;

public class Main {
    public static void main(String[] args) {
        Joueur j1 = new Joueur("Lolow");
        for(int i = 0; i< 25; i++){
            j1.effectuerUneQuete();
        }
        System.out.println("Le joueur " + j1.getNom() + " finit sa partie avec " + j1.getExp() + " exp et niveau " + j1.getNiveau());
    }
}
