package org.example.exercices.exercice8Banque;

import java.sql.Array;

public class Client {
    private String nom;
    private String prenom;
    private int identifiant;
    private CompteBancaire[] listeDesComptes;
    private String numeroTel;

    public Client(String nom, String prenom, int identifiant, String numeroTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.numeroTel = numeroTel;
        this.listeDesComptes = new CompteBancaire[]{};
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public CompteBancaire[] getListeDesComptes() {
        return listeDesComptes;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    private void ajouterCompteBancaire(CompteBancaire compte) {
        CompteBancaire[] nouvelleListeCompte = new CompteBancaire[listeDesComptes.length + 1];
        nouvelleListeCompte[nouvelleListeCompte.length - 1] = compte;
        this.listeDesComptes = nouvelleListeCompte;
    }

    public void creerCompteBancaire(int choixCompte, double soldeInitial) {
        CompteBancaire nouveauCompte = null;
        switch (choixCompte) {
            case 1 -> {
                nouveauCompte = new CompteCourant(soldeInitial, this);
            }
            case 2 -> {
                nouveauCompte = new CompteEpargne(soldeInitial, this);
            }
            case 3 -> {
                nouveauCompte = new ComptePayant(soldeInitial, this);
            }
        }
        if (nouveauCompte != null) {
            ajouterCompteBancaire(nouveauCompte);
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", identifiant=" + identifiant +
                '}';
    }
}
