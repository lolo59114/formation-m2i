package org.example.exercicesJPA.exercice2Billeterie.Util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Util;
import org.example.exercicesJPA.exercice2Billeterie.Entity.Address;
import org.example.exercicesJPA.exercice2Billeterie.Entity.Customer;
import org.example.exercicesJPA.exercice2Billeterie.Entity.Event;
import org.example.exercicesJPA.exercice2Billeterie.Entity.Ticket;
import org.example.exercicesJPA.exercice2Billeterie.Repository.AddressRepository;
import org.example.exercicesJPA.exercice2Billeterie.Repository.CustomerRepository;
import org.example.exercicesJPA.exercice2Billeterie.Repository.EventRepository;
import org.example.exercicesJPA.exercice2Billeterie.Repository.TicketRepository;

import java.time.LocalDateTime;

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
                case "1" -> createTicketReservation();
                case "2" -> displayReadMenu();
                case "3" -> displayCreationMenu();
                case "4" -> displayUpdateMenu();
                case "5" -> displayDeleteMenu();
                default -> {
                    return;
                }
            }
        }
    }

    private static void displayDeleteMenu() {
        displayCustomMenu("Delete Menu", "Delete");
    }

    private static void displayUpdateMenu() {
        displayCustomMenu("Update Menu", "Update");
    }

    private static void displayReadMenu() {
        displayCustomMenu("Selection Menu", "Read");
    }

    private static void displayCreationMenu() {
        displayCustomMenu("Creation Menu", "Create");
    }

    private static void displayCustomMenu(String title, String action) {
        while (true) {
            System.out.println("==== " + title + " ====");
            System.out.println("1. " + action + " customer");
            System.out.println("2. " + action + " event");
            if (!action.equals("Update")) {
                System.out.println("3. " + action + " ticket");
            }
            System.out.println("0. Return to home");

            String choice = Util.askInput("Votre choix:", String.class);
            switch (choice) {
                case "1" -> doActionForCustomer(action);
                case "2" -> doActionForEvent(action);
                default -> {
                    return;
                }
            }
        }
    }

    private static void doActionForEvent(String action) {
        switch (action) {
            case "Read" -> {
                readEvent();
            }
            case "Create" -> {
                if(createEvent().getId() > 0)
                    System.out.println("Event has been created");
            }
            case "Update" -> {
                updateEvent();
            }
            case "Delete" -> {
                deleteEvent();
            }
        }
    }

    private static void deleteEvent() {

    }

    private static void updateEvent() {
        int eventId = Util.askInput("Event to update:", Integer.class);
        Event event = eventRepository.getEventById(eventId);
        if (event == null) {
            System.out.println("No event found with id " + eventId);
            Util.askBeforeContinue();
        } else {
            while(true) {
                displayEventMenuModification(event);
                String modificationChoice = Util.askInput("Field to update:", String.class);
                switch (modificationChoice) {
                    case "0" -> {
                        eventRepository.updateEvent(event);
                        System.out.println("Event has been updated");
                        Util.askBeforeContinue();
                        return;
                    }
                    case "1" -> event.setName(Util.askInput("New name:", String.class));
                    case "2" -> event.setStartDate(LocalDateTime.parse(Util.askInput("New start date(yyyy-MM-jjTHH:mm:ss)", String.class)));
                    case "3" -> event.setPlaceNumber(Util.askInput("New place number:", Integer.class));
                }
            }
        }
    }

    private static void displayEventMenuModification(Event event) {
        System.out.println("=== Modification Event menu ===");
        System.out.println("1. Name : " + event.getName());
        System.out.println("2. Place number : " + event.getPlaceNumber());
        System.out.println("3. Start date : " + event.getStartDate());
        System.out.println("0. Finish modification");
    }

    private static Event createEvent() {
        Event event = new Event();
        event.setName(Util.askInput("Name:", String.class));
        event.setStartDate(LocalDateTime.parse(Util.askInput("Start date(yyyy-MM-jjTHH:mm:ss):", String.class)));
        event.setPlaceNumber(Util.askInput("Place number:", Integer.class));
        event.setAddress(createAddress());
        eventRepository.createEvent(event);
        return event;
    }

    private static void readEvent() {
        int eventId = Util.askInput("Event to read:", Integer.class);
        Event event = eventRepository.getEventById(eventId);
        if (event == null) {
            System.out.println("No event found with id " + eventId);
        } else {
            System.out.println(event);
        }
        Util.askBeforeContinue();
    }

    private static void doActionForCustomer(String action) {
        switch (action) {
            case "Read" -> {
                readCustomer();
            }
            case "Create" -> {
                if(createCustomer().getId() > 0)
                    System.out.println("Customer has been created");
            }
            case "Update" -> {
                updateCustomer();
            }
            case "Delete" -> {
                deleteCustomer();
            }
        }
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setStreet(Util.askInput("Street:", String.class));
        address.setCity(Util.askInput("City:", String.class));
        return address;
    }

    private static Customer createCustomer() {
        Customer customer = new Customer();
        customer.setFirstName(Util.askInput("First name:", String.class));
        customer.setLastName(Util.askInput("Last name:", String.class));
        customer.setAge(Util.askInput("Age:", Integer.class));
        customer.setPhoneNumber(Util.askInput("Phone number:", String.class));
        customer.setAddress(createAddress());
        customerRepository.createCustomer(customer);
        return customer;
    }

    private static void deleteCustomer() {
        displayCustomers();
        int customerId = Util.askInput("Customer id to delete:", Integer.class);
        Customer customer = customerRepository.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("No customer found with id " + customerId);
            Util.askBeforeContinue();
        } else {
            if(customerRepository.deleteCustomer(customer))
                System.out.println("Customer has been deleted");
        }
    }

    private static void updateCustomer() {
        int customerId = Util.askInput("Customer to update:", Integer.class);
        Customer customer = customerRepository.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("No customer found with id " + customerId);
            Util.askBeforeContinue();
        } else {
            while(true) {
                displayCustomerMenuModification(customer);
                String modificationChoice = Util.askInput("Field to update:", String.class);
                switch (modificationChoice) {
                    case "0" -> {
                        if(customerRepository.updateCustomer(customer))
                            System.out.println("Customer has been updated");
                        return;
                    }
                    case "1" -> customer.setFirstName(Util.askInput("New first name:", String.class));
                    case "2" -> customer.setLastName(Util.askInput("New last name:", String.class));
                    case "3" -> customer.setAge(Util.askInput("New age:", Integer.class));
                    case "4" -> customer.setPhoneNumber(Util.askInput("New phone number:", String.class));
                }
            }
        }
    }

    private static void displayCustomerMenuModification(Customer customer) {
        System.out.println("=== Modification Customer menu ===");
        System.out.println("1. First Name : " + customer.getFirstName());
        System.out.println("2. Last Name : " + customer.getLastName());
        System.out.println("3. Age : " + customer.getAge());
        System.out.println("4. Phone number: " + customer.getPhoneNumber());
        System.out.println("0. Finish modification");
    }

    private static void readCustomer() {
        int customerId = Util.askInput("Customer to read:", Integer.class);
        Customer customer = customerRepository.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("No customer found with id " + customerId);
        } else {
            System.out.println(customer);
        }
        Util.askBeforeContinue();
    }

    private static Ticket createTicket(Customer customer, Event event) {
        Ticket ticket = Ticket.builder()
                .customer(customer)
                .event(event)
                .build();
        ticket.setType(TicketType.valueOf(Util.askInput("Type (Standard, gold, vip):", String.class)));
        ticketRepository.createTicket(ticket);
        return ticket;
    }

    private static void displayTickets() {
        for(Ticket ticket : ticketRepository.getAllTickets()) {
            System.out.println(ticket.toStringEvent());
        }
    }

    private static void displayEvents() {
        for(Event event : eventRepository.getAllEvents()) {
            System.out.println(event);
        }
    }

    private static void displayCustomers() {
        for (Customer customer : customerRepository.getAllCustomers()) {
            System.out.println(customer);
        }
    }

    private static void createTicketReservation() {
        displayCustomers();
        int customerId = Util.askInput("Choose the customer id:", Integer.class);
        Customer customer = customerRepository.getCustomerById(customerId);
        if(customer == null) {
            System.out.println("No customer found with id: " + customerId);
        } else {
            displayEvents();
            int eventId = Util.askInput("Choose the event id:", Integer.class);
            Event event = eventRepository.getEventById(eventId);
            if(event == null) {
                System.out.println("No event found with id:" + eventId);
            } else {
                Ticket ticket = createTicket(customer, event);
                if(ticket.getId() > 0) {
                    System.out.println("Ticket has been created");
                    Util.askBeforeContinue();
                }
            }
        }
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
