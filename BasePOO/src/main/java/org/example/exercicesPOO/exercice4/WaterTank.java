package org.example.exercicesPOO.exercice4;

public class WaterTank {
    private String nom;
    private int poidsAVide;
    private int capaciteMax;
    private int niveauRemplissage;
    private static int totalVolume;

    public WaterTank(String nom, int poidsAVide, int capaciteMax, int niveauRemplissage) {
        this.nom = nom;
        this.poidsAVide = poidsAVide;
        this.capaciteMax = capaciteMax;
        setNiveauRemplissage(niveauRemplissage);
    }

    public String getNom() {
        return nom;
    }

    public int getPoidsAVide() {
        return poidsAVide;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public int getNiveauRemplissage() {
        return niveauRemplissage;
    }

    public static int getTotalVolume() {
        return totalVolume;
    }

    private void setNiveauRemplissage(int niveauRemplissage) {
        WaterTank.totalVolume -= this.niveauRemplissage;
        if(niveauRemplissage > 0){
            this.niveauRemplissage = Math.min(niveauRemplissage, capaciteMax);
        } else {
            this.niveauRemplissage = 0;
        }
        WaterTank.totalVolume += this.niveauRemplissage;
    }

    public int remplir(int volume){
        int excesEau = 0;
        if(this.niveauRemplissage + volume > capaciteMax) {
            excesEau = this.niveauRemplissage + volume - capaciteMax;
        }
        setNiveauRemplissage(this.niveauRemplissage + volume);
        return excesEau;
    }

    public int vider(int volume){
        int eauPrise = volume;
        if ((this.niveauRemplissage - volume) < 0) {
            eauPrise = this.niveauRemplissage;
        }
        setNiveauRemplissage(this.niveauRemplissage - volume);
        return eauPrise;
    }

    public void afficherPoidsTotal(){
        System.out.println("Poids total de " + nom + " : " + (poidsAVide + niveauRemplissage) + "Kg");
    }

    @Override
    public String toString() {
        return "WaterTank{" +
                "nom='" + nom + '\'' +
                ", poidsAVide=" + poidsAVide +
                ", capaciteMax=" + capaciteMax +
                ", niveauRemplissage=" + niveauRemplissage +
                '}';
    }

}
