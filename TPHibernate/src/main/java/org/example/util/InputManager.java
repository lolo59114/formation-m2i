package org.example.util;

import org.example.Exception.ChoiceOutOfIndexException;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Scanner;

public class InputManager {
    private static Scanner scanner = new Scanner(System.in);

    public static void askBeforeContinue() {
        System.out.println("Appuyez sur entrée pour continuer...");
        scanner.nextLine();
    }

    public static <T extends Enum<T>> T askFromEnum(T[] enumValues, String name) {
        int choice;
        do {
            System.out.println("Liste des "+ name +":");
            for (int i = 0; i < enumValues.length; i++) {
                System.out.println((i + 1) + ". " + enumValues[i]);
            }
            choice = askInput("Votre choix: ", Integer.class);
        } while (choice < 1 || choice > enumValues.length);
        return enumValues[choice - 1];
    }

    public static CategoryMode askCategoryMode() {
        CategoryMode[] categoryModes = CategoryMode.values();
        int choice;
        do {
            System.out.println("Liste des catégories:");

            for (int i = 0; i < categoryModes.length; i++) {
                System.out.println((i + 1) + ". " + categoryModes[i]);
            }
            choice = askInput("Votre choix: ", Integer.class);
        } while (choice < 1 || choice > categoryModes.length);

        return categoryModes[choice - 1];
    }

    public static <T> T askInput(String asked, Class<T> type) {
        while (true) {
            System.out.println(asked);
            try {
                T inputValue;
                String inputString = scanner.nextLine();
                // la classe String n'a pas de méthode valueOf
                if (type.equals(String.class)) {
                    inputValue = type.cast(inputString);
                } else if (type.equals(LocalDate.class)) {
                    Method parse = type.getMethod("parse", CharSequence.class);
                    inputValue = type.cast(parse.invoke(null,inputString));
                } else {
                    Method valueOf = type.getMethod("valueOf", String.class);
                    inputValue = type.cast(valueOf.invoke(null, inputString));
                }
                return inputValue;
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }

    public static String askInputChoice(int maxChoiceValue) {
        while (true) {
            System.out.println("Votre choix");
            try {
                String inputString = scanner.nextLine();
                int choiceValue = Integer.parseInt(inputString);
                if (choiceValue < 0 || choiceValue > maxChoiceValue)
                    throw new ChoiceOutOfIndexException("Votre choix n'est pas valide.");
                return inputString;
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }
}
