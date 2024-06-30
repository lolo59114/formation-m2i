package org.example.controller;

import org.example.util.InputManager;

public class IHMGlobal {
    private IHMArticle ihmArticle;

    public IHMGlobal() {
        ihmArticle = new IHMArticle();
    }

    public void start() {
        String choice;
        while (true) {
            System.out.println("""
                === Menu principal
                1. Menu Inventaire
                2. Menu Vente
                3. Menu Client
                0. Quitter l'application
                """);
            choice = InputManager.askInputChoice(3);
            switch (choice) {
                case "1" -> ihmArticle.start();
                default -> {
                    return;
                }
            }
        }

    }

}
