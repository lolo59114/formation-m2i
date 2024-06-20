package org.example.exercices.exercice8Banque;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private int identifiant;
    private List<CompteBancaire> listeDesComptes;
    private String numeroTel;

    public Client(String nom, String prenom, int identifiant, String numeroTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.numeroTel = numeroTel;
        this.listeDesComptes = new ArrayList<>();
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

    public List<CompteBancaire> getListeDesComptes() {
        return listeDesComptes;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    private void ajouterCompteBancaire(CompteBancaire compte) {
        listeDesComptes.add(compte);
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
