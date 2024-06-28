package org.example.controller;

import org.example.service.ArticleService;
import org.example.util.CategoryMode;
import org.example.util.InputManager;

import java.time.LocalDate;

public class IHMArticle {
    private ArticleService articleService;

    public IHMArticle() {
        articleService = new ArticleService();
    }

    public void start() {
        String choice;
        while (true) {
            System.out.println("""
                === Menu Inventaire ===
                1. Ajouter un article
                2. Modifier un article
                3. Supprimer un article
                4. Consulter un article
                5. Consulter tous les articles
                6. Restocker les articles
                0. Retour au menu principal
                """);
            choice = InputManager.askInput("Votre choix:", String.class);
            switch (choice) {
                case "1" -> articleService.create();
                case "2" -> articleService.update();
                case "3" -> articleService.delete();
                case "4" -> articleService.findById();
                case "5" -> articleService.displayAll();
                case "6" -> {}
                default -> {
                    return;
                }
            }
            InputManager.askBeforeContinue();
        }
    }
}
