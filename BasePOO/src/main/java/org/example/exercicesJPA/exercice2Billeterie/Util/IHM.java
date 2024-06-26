package org.example.exercicesJPA.exercice2Billeterie.Util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Util;
import org.example.exercicesJPA.exercice2Billeterie.Repository.AddressRepository;
import org.example.exercicesJPA.exercice2Billeterie.Repository.CustomerRepository;
import org.example.exercicesJPA.exercice2Billeterie.Repository.EventRepository;
import org.example.exercicesJPA.exercice2Billeterie.Repository.TicketRepository;

public class IHM {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    private static AddressRepository addressRepository = new AddressRepository(emf);
    private static CustomerRepository customerRepository = new CustomerRepository(emf);
    private static EventRepository eventRepository = new EventRepository(emf);
    private static TicketRepository ticketRepository = new TicketRepository(emf);
    public static void startApp() {
        while (true) {
            displayMainMenu();
            String choice = Util.askInput("Votre choix:", String.class);
            switch (choice) {
                case "1" -> displayTicketReservationMenu();
                case "2" -> {}
                case "3" -> displayCreationMenu();
                default -> {
                    return;
                }
            }
        }
    }

    private static void displayCreationMenu() {
        System.out.println("""
                === Creation Menu ===
                1. Create customer
                2. Create event
                3. Create ticket
                4. Create address
                """);
    }

    private static void displayTicketReservationMenu() {
    }

    private static void displayMainMenu() {
        System.out.println("""
                === Main menu ===
                1. Ticket reservation
                2. Read menu
                3. Creation menu
                4. Update menu
                5. Delete menu
                0. Close application
                """);
    }



}
