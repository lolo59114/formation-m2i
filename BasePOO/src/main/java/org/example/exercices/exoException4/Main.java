package org.example.exercices.exoException4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        startMenu();
    }

    private static void startMenu() {
        while (true) {
            displayMenu();
            System.out.println("Votre choix : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "0" -> {
                    return;
                }
                case "1" -> createStudent(students);
                case "2" -> displayStudentList(students);
                default -> System.out.println("Choix invalide");
            }
        }
    }

    private static void displayStudentList(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("\n Appuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }

    private static void createStudent(List<Student> studentList) {
        studentList.add(new Student(askName(), askAge()));
    }

    private static String askName() {
        String name = "";
        while (true) {
            System.out.println("Entrez le nom de l'étudiant: ");
            try {
                name = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Nom invalide.");
            }
        }
        return name;
    }

    private static int askAge() {
        int age = 0;
        while (true) {
            System.out.println("Entrez l'âge de l'étudiant: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 0) {
                    throw new InvalidAgeException("Age invalide");
                }
                break;
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("La valeur saisie est incorrecte.");
            }
        }
        return age;
    }

    private static void displayMenu() {
        System.out.println("""
                === Gestion des étudiants ===
                1. Ajouter un nouvel étudiant
                2. Afficher la liste des étudiants
                0. Fermer l'application
                """);
    }


}
