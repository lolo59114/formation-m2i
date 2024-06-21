package org.example.exercices.exoException3;

public class Main {
    public static void main(String[] args) {
        int[] tableau = {1,2,3,4,5};
        try {
            System.out.println("Le 4eme élément du tableau est : " + tableau[4]);
            System.out.println("Le 5eme élément du tableau est : " + tableau[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
