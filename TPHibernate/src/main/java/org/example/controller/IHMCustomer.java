package org.example.controller;

import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.example.util.DisplayManager;
import org.example.util.InputManager;

import java.util.List;

public class IHMCustomer {
    CustomerService customerService;

    public IHMCustomer() {
        customerService = new CustomerService();
    }

    public void start() {
        String choice;
        while (true) {
            System.out.println("""
                    === Menu Client ===
                    1. Ajouter un client
                    2. Modifier un client
                    3. Supprimer un client
                    4. Consulter un client
                    5. Afficher l'historique d'achat d'un client
                    6. Afficher tous les clients
                    0. Retour au menu principal
                    """);
            choice = InputManager.askInputChoice(6);
            switch (choice) {
                case "1" -> createCustomer();
                case "2" -> updateCustomer();
                case "3" -> deleteCustomer();
                case "4" -> displayCustomerById(false);
                case "5" -> displayCustomerById(true);
                case "6" -> displayAllCustomers();
                default -> {
                    return;
                }
            }
            InputManager.askBeforeContinue();
        }
    }

    private void createCustomer() {
        System.out.println("=== Création d'un client ===");
        String name = InputManager.askInput("Nom :", String.class);
        String email = InputManager.askInput("Email :", String.class);
        if(customerService.create(name, email)) {
            System.out.println("Le client a bien été créé");
        }
    }

    private void updateCustomer() {
        System.out.println("=== Modification d'un client ===");
        long id = InputManager.askInput("Id de l'article à modifier:", Long.class);
        Customer customer = customerService.findById(id);
        if(customer == null) {
            System.out.println("Le client avec id " + id + " n'a pas été trouvé");
        } else {
            System.out.println(customer);
            String name = InputManager.askInput("Nom (" + customer.getName() + "):", String.class);
            String email = InputManager.askInput("Email (" + customer.getEmail() + "):", String.class);
            customer.setName("".equals(name) ? customer.getName() : name);
            customer.setEmail("".equals(email) ? customer.getEmail() : email);
            if(customerService.update(customer)) {
                System.out.println("Le client a bien été modifié");
            }
        }
    }

    private void deleteCustomer() {
        System.out.println("=== Suppression d'un client ===");
        long id = InputManager.askInput("Id du client à supprimer:", Long.class);
        if (customerService.delete(id)) {
            System.out.println("Le client a bien été supprimé");
        }
    }

    private void displayCustomerById(boolean isHistory) {
        System.out.println("=== Affichage d'un client ===");
        long id = InputManager.askInput("Id du client à afficher:", Long.class);
        Customer customer = customerService.findById(id);
        if(customer == null) {
            System.out.println("Le client avec id " + id + " n'a pas été trouvé");
        } else {
            System.out.println(customer);
            if(isHistory) {

                System.out.println(customer.toStringSaleHistory());
            }
        }
    }


    private void displayAllCustomers() {
        List<Customer> customers = customerService.getAll();
        DisplayManager.displayList(customers, Customer.class);
    }
}
