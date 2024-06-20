package org.example.exercices.exercice3;

public class Joueur {
    private String nom;
    private int niveau = 1;
    private int exp;

    public Joueur(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getExp() {
        return exp;
    }

    private void setExp(int exp) {
        this.exp = exp;
        checkLvlUp();
    }

    public void effectuerUneQuete(){
        setExp(getExp() + 10);
        //this.exp += 10;
        //checkLvlUp();
    }

    private void checkLvlUp(){
        if(exp > 100){
            exp -= 100;
            niveau++;
            System.out.println("Le joueur " + nom + " a gagné un niveau, il est maintenant niveau " + niveau);
        }
    }
}
