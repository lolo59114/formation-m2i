package org.example.exercicesJPA.exercice1Zoo.Util;

import org.example.exercicesJPA.exercice1Zoo.Entity.Animal;
import org.example.exercicesJPA.exercice1Zoo.Repository.AnimalRepository;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private static Scanner scanner = new Scanner(System.in);
    private static AnimalRepository animalRepository;
    public static void startApp(){
        animalRepository = new AnimalRepository();
        while(true){
            displayMenu();
            String choice = askInput("Votre choix: ", String.class);
            switch(choice){
                case "0" -> {
                    return;
                }
                case "1" -> createAnimal();
                case "2" -> displayAnimalById();
                case "3" -> displayAnimalsByName();
                case "4" -> displayAnimalsByRegime();
            }
        }
    }

    private static void displayAnimalsByRegime() {
        System.out.println("""
                0. Carnivore
                1. Herbivore
                2. Omnivore
                """);
        int regime = askInput("Votre choix: ", Integer.class);
        List<Animal> animals = animalRepository.getAnimalsByRegime(Diet.values()[regime]);
        for(Animal animal : animals){
            System.out.println(animal);
        }
        askBeforeContinue();
    }

    private static void displayAnimalsByName() {
        String name = askInput("Nom de l'animal: ", String.class);
        List<Animal> animals = animalRepository.getAnimalsByName(name);
        for(Animal animal : animals){
            System.out.println(animal);
        }
        askBeforeContinue();
    }

    private static void displayAnimalById() {
        int id = askInput("Id de l'animal: ", Integer.class);
        Animal animal = animalRepository.getAnimal(id);
        System.out.println(animal);
        askBeforeContinue();
    }

    private static void createAnimal() {
        String animalName = askInput("Nom animal: ", String.class);
        int age = askInput("Age: ", Integer.class);
        int regime = askInput("Regime alimentaire \n 0. Carnivore\n 1.Herbivore \n2.Omnivore ", Integer.class);
        String dateArrivee = askInput("Date arrivee(yyyy-MM-jj): ", String.class);
        Animal animal = Animal.builder()
                .name(animalName)
                .age(age)
                .regimeAlim(Diet.values()[regime])
                .dateArrivee(LocalDate.parse(dateArrivee))
                .build();
        animalRepository.createAnimal(animal);
    }

    public static void displayMenu() {
        System.out.println("""
                === Menu principal ===
                1. Création d'un animal
                2. Rechercher un animal par id
                3. Rechercher un animal par nom
                4. Rechercher un animal par regime alimentaire
                0. Quitter l'application
                """);
    }

    private static void askBeforeContinue() {
        System.out.println("Appuyez sur entrée pour continuer...");
        scanner.nextLine();
    }

    private static <T> T askInput(String asked, Class<T> type) {
        while (true) {
            System.out.println(asked);
            try {
                T inputValue;
                String inputString = scanner.nextLine();
                // la classe String n'a pas de méthode valueOf
                if (!type.equals(String.class)) {
                    Method valueOf = type.getMethod("valueOf", String.class);
                    inputValue = type.cast(valueOf.invoke(null, inputString));
                } else {
                    inputValue = type.cast(inputString);
                }
                return inputValue;
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }
}
