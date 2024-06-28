package org.example;

import org.example.controller.IHMGlobal;
import org.example.entity.ArticleElectronic;
import org.example.entity.ArticleMode;
import org.example.repository.ArticleRepository;
import org.example.util.CategoryMode;
import org.example.util.InputManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        new IHMGlobal().start();


//        ArticleElectronic elec = ArticleElectronic.builder()
//                .price(5)
//                .durationInMinutes(12805)
//                .description("Réveil")
//                .quantityAvailable(5)
//                .build();
//
//        ArticleRepository articleRepository = new ArticleRepository();
//        articleRepository.save(elec);
    }
}