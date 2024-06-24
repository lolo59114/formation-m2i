package org.example.exercicesPOO.exoException2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Veuillez saisir un nombre entier positif: ");
            try {
                int entier = Integer.parseInt(scanner.nextLine());
                if (entier < 0)
                    throw new ArithmeticException("Le nombre saisi est négatif.");
                double resultat = Math.sqrt(entier);
                System.out.println("La racine carré de " + entier + " est " + resultat);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Votre saisie est incorrecte");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
