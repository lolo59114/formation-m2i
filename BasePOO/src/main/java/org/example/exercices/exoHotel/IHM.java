package org.example.exercices.exoHotel;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Scanner;

public class IHM {
    private static Scanner scanner = new Scanner(System.in);
    public static void startMenu() {
        while (true) {
            displayMenu();
            System.out.println("Votre choix : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "0" -> {
                    return;
                }
                case "1" -> addCustomer();
                case "2" -> displayCustomerList();
                case "3" -> displayCustomerBooking();
                case "4" -> addBooking();
                case "5" -> cancelBooking();
                case "6" -> displayBookingList();
                default -> System.out.println("Choix invalide");
            }
        }
    }


    private static void displayBookingList() {
    }

    private static void cancelBooking() {
    }

    private static void addBooking() {
    }

    private static void displayCustomerBooking() {
    }

    private static void displayCustomerList() {
    }

    private static void addCustomer() {
    }

    private static void displayMenu() {
        System.out.println("""
                    === Menu Principal ===
                    1. Ajouter un client
                    2. Afficher la liste des clients
                    3. Afficher les réservations d'un client
                    4. Ajouter une réservation
                    5. Annuler une réservation
                    6. Afficher la liste des réservations
                    0. Quitter
                    """);
    }

    private static <T> T askInput(String asked, Class<T> type) {
        while (true) {
            System.out.println(asked);
            try {
                String inputString = scanner.nextLine();
                Method valueOf = type.getMethod("valueOf", String.class);
                return type.cast(valueOf.invoke(null, inputString));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

//    private static String askString(String asked, String errMess) {
//        String inputString = "";
//        while (true) {
//            System.out.println(asked);
//            try {
//                inputString = scanner.nextLine();
//                break;
//            } catch (Exception e) {
//                System.out.println(errMess);
//            }
//        }
//        return inputString;
//    }

    private static <T> T askInput(String asked, String errMess, Class<T> type) {
        while (true) {
            System.out.println(asked);
            try {
                String inputString = scanner.nextLine();
                Method valueOf = type.getMethod("valueOf", String.class);
                return type.cast(valueOf.invoke(null, inputString));
            } catch (Exception e) {
                System.out.println(errMess);
            }
        }
    }
}
