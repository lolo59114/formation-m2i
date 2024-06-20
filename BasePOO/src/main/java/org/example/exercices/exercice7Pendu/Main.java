package org.example.exercices.exercice7Pendu;

public class Main {
    public static void main(String[] args) {
        Pendu pendu;
        IHM.affichageDebut();
        if(IHM.saisiNombreEssaiParDefaut().equals("y")) {
            pendu = new Pendu(IHM.saisiNombreEssai());
        } else {
            pendu = new Pendu();
        }
        IHM.affichageCreationPendu(pendu.getNbEssaiMax());
        do {
            IHM.affichageMotATrouver(pendu.getMasque());
            IHM.affichageNoEssaiRestant(pendu.getNoEssai(), pendu.getNbEssaiMax());
            pendu.testerChar(IHM.saisiLettrePendu());
            if (!pendu.testerVictoire()) {
                IHM.affichagePendu(pendu.getNoEssai(), pendu.getNbEssaiMax());
                if (pendu.getNoEssai() > pendu.getNbEssaiMax()) {
                    IHM.affichageDefaite(pendu.getMotATrouver());
                    break;
                }
            } else {
                IHM.affichageVictoire(pendu.getNoEssai());
                break;
            }
        } while(true);
    }
}
