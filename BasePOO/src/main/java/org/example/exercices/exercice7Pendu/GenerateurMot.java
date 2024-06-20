package org.example.exercices.exercice7Pendu;

import java.util.Random;

public class GenerateurMot {
    private static String[] mots = {
        "chien", "chat", "loupe", "joueur"
    };


    public static String genereUnMot() {
        Random rand = new Random();
        return mots[rand.nextInt(mots.length - 1)];
    }
}
