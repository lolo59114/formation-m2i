package org.example.exercicesPOO.exercice7Pendu;

public class Pendu {
    private String masque = "";
    private int nbEssaiMax;
    private int noEssai = 1;
    private String motATrouver = "";
    private String lettresProposees = "";

    public Pendu(int nbEssaiMax) {
        this.nbEssaiMax = nbEssaiMax;
        this.motATrouver = GenerateurMot.genereUnMot();
        genererMasque();
    }

    public Pendu() {
        this(10);
    }

    public String getMasque() {
        return masque;
    }

    public int getNbEssaiMax() {
        return nbEssaiMax;
    }

    public int getNoEssai() {
        return noEssai;
    }

    public String getMotATrouver() {
        return motATrouver;
    }

    public String getLettresProposees() {
        return lettresProposees;
    }

    public void testerChar(String lettre) {
        if(lettre.length() == 1) {
            boolean lettreTrouve = false;
            int indexTrouve = motATrouver.indexOf(lettre);
            while (indexTrouve >= 0) {
                lettreTrouve = true;
                StringBuilder monMasque = new StringBuilder(masque);
                monMasque.setCharAt(indexTrouve, lettre.toCharArray()[0]);
                masque = monMasque.toString();
                indexTrouve = motATrouver.indexOf(lettre, indexTrouve + 1);
            }
            if(!lettreTrouve) {
                noEssai++;
            }
        }
    }

    private boolean testerDefaite() {
        return (noEssai > nbEssaiMax);
    }

    public boolean testerVictoire() {
        return !masque.contains("*");
    }

    private void genererMasque() {
        masque = masque + "*".repeat(motATrouver.length());
    }

}