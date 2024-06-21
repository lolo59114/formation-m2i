package org.example.exercices.exoException1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int entier = 0;
        while (true) {
            System.out.println("Veuillez saisir un entier : ");
            try {
                entier = Integer.parseInt(scanner.nextLine());
                System.out.println("Entier saisi par l'utilisateur : "  + entier);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Votre saisie est incorrecte");
            }
        }
    }
}
