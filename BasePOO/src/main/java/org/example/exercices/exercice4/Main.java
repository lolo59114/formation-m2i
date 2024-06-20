package org.example.exercices.exercice4;

public class Main {
    public static void main(String[] args) {
        WaterTank w1 = new WaterTank("WaterTank 1", 20, 20, 10);
        System.out.println(w1.getNom() + " volume de départ : " + w1.getNiveauRemplissage());
        WaterTank w2 = new WaterTank("WaterTank 2", 5, 10, 10);
        System.out.println(w2.getNom() + " volume de départ : " + w2.getNiveauRemplissage());
        System.out.println("----------------------");
        w1.afficherPoidsTotal();
        w2.afficherPoidsTotal();
        System.out.println("----------------------");
        int excessWater = w1.remplir(-11);
        System.out.println("Quantité d'eau dans la citerne 1 après ajout de 11 litres: " + w1.getNiveauRemplissage() + "/" + w1.getCapaciteMax());
        System.out.println("Excès d'eau récupéré : " + excessWater);
        int waterTaken = w2.vider(-11);
        System.out.println("Quantité d'eau dans la citerne 2 après tentative de retrait de 11 litres: " + w2.getNiveauRemplissage() + "/" + w2.getCapaciteMax());
        System.out.println("Quantité d'eau récupérée : " + waterTaken);
        System.out.println("----------------------");
        System.out.println("Quantité d'eau dans la citerne 1 : " + w1.getNiveauRemplissage());
        System.out.println("Quantité d'eau dans la citerne 2 : " + w2.getNiveauRemplissage());
        System.out.println("Quantité d'eau dans toutes les citernes : " + WaterTank.getTotalVolume());
        System.out.println(w1);
        System.out.println(w2);

    }
}
