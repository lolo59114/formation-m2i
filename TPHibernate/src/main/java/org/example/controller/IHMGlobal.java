package org.example.controller;

import org.example.util.InputManager;

public class IHMGlobal {
    private IHMArticle ihmArticle;

    public IHMGlobal() {
        ihmArticle = new IHMArticle();
    }

    public void start() {
        String choice;
        System.out.println("""
                === Menu principal
                1. Menu Inventaire
                2. Menu Vente
                3. Menu Client
                """);
        choice = InputManager.askInput("Votre choix:", String.class);
        switch (choice) {
            case "1" -> ihmArticle.start();
        }
    }

}
