package org.example.exercicesPOO.exoHotel;

import org.example.exercicesPOO.exoHotel.enums.BookingState;
import org.example.exercicesPOO.exoHotel.enums.RoomState;
import org.example.exercicesPOO.exoHotel.model.Booking;
import org.example.exercicesPOO.exoHotel.model.Customer;
import org.example.exercicesPOO.exoHotel.model.Hotel;
import org.example.exercicesPOO.exoHotel.model.Room;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private static Scanner scanner = new Scanner(System.in);
    public static void startMenu() {
        String hotelName = askInput("Quel est le nom de l'hôtel ?", String.class);
        Hotel hotel = new Hotel(hotelName);
        hotel.addRoom(new Room(1, RoomState.FREE, 2, 15));
        hotel.addRoom(new Room(2, RoomState.FREE, 3, 20));
        hotel.addRoom(new Room(3, RoomState.FREE, 4, 23.5));
        hotel.addRoom(new Room(4, RoomState.OCCUPIED, 2, 15));
        while (true) {
            displayMenu();
            System.out.println("Votre choix : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "0" -> {
                    return;
                }
                case "1" -> {
                    Customer client = createCustomer();
                    hotel.addCustomer(client);
                    System.out.println("Client ajouté avec succès !");
                }
                case "2" -> displayCustomerList(hotel.getCustomers());
                case "3" -> {
                    displayCustomerList(hotel.getCustomers());
                    int idClient = askInput("Choisissez le numéro du client: ", Integer.class);
                    Customer customer = hotel.getCustomerById(idClient);
                    if (customer == null) {
                        System.out.println("Le client choisi n'existe pas !");
                    } else {
                        displayCustomerBooking(customer);
                    }

                }
                case "4" -> startAddBookingMenu(hotel);
                case "5" -> {
                    displayBookingList(hotel.getBookings(), BookingState.PLANNED);
                    int idBooking = askInput("Choisissez la réservation à annuler: ", Integer.class);
                    cancelBooking(hotel.getBookings().get(idBooking-1));
                }
                case "6" -> displayBookingList(hotel.getBookings());
                default -> System.out.println("Choix invalide");
            }
        }
    }

    private static void startAddBookingMenu(Hotel hotel) {
        while (true) {
            Booking newBooking = new Booking();
            displayAddBookingMenu();
            System.out.println("Votre choix : ");
            String bookingMenuChoice = scanner.nextLine();
            switch (bookingMenuChoice) {
                case "0" -> {
                    return;
                }
                case "1" -> {
                    displayCustomerList(hotel.getCustomers());
                    int customerId = askInput("Qui est le client ?", Integer.class);
                    Customer customer = hotel.getCustomerById(customerId);
                    newBooking.setCustomer(customer);
                }
                case "2" -> {
                    displayRooms(hotel.getRooms(), RoomState.FREE);
                    int roomId = askInput("Choisissez un numéro de chambre: ", Integer.class);
                    Room room = hotel.getRoomById(roomId);
                    newBooking.addRoom(room);
                }
                case "3" -> {
                    if (newBooking.getCustomer() != null && !newBooking.getRooms().isEmpty()) {
                        hotel.addBooking(newBooking);
                        System.out.println("Réservation ajoutée avec succès !");
                        return;
                    } else {
                        System.out.println("Réservation incomplète !");
                    }
                }
                default -> System.out.println("Choix invalide");
            }
        }
    }

    private static void displayBookingList(List<Booking> bookings, BookingState state) {
        List<Booking> bookingsFiltered = bookings.stream()
                                        .filter(b -> b.getBookingState() == state)
                                        .toList();
        displayBookingList(bookingsFiltered);
    }

    private static void displayBookingList(List<Booking> bookings) {
        for(Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    private static void cancelBooking(Booking booking) {
        for (Room room : booking.getRooms()) {
            room.setRoomState(RoomState.FREE);
        }
        booking.setBookingState(BookingState.CANCELLED);
    }


    private static void displayAddBookingMenu() {
        System.out.println("""
                === Ajout d'une réservation ===
                1. Choisir le client
                2. Choisir une chambre
                3. Valider la réservation
                0. Annuler et retourner au menu principal
                """);
    }

    private static void displayRooms(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private static void displayRooms(List<Room> rooms, RoomState state) {
        List<Room> roomsFiltered = rooms.stream()
                                    .filter(r -> r.getRoomState() == state)
                                    .toList();
        displayRooms(roomsFiltered);
    }

    private static void displayCustomerBooking(Customer customer) {
        for (Booking booking : customer.getBookings()) {
            System.out.println(booking);
        }
    }

    private static void displayCustomerList(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static Customer createCustomer() {
        System.out.println("=== Ajout d'un client ===");
        String lastName = askInput("Quel est le nom du client ?", String.class);
        String firstName = askInput("Quel est le prénom du client ?", String.class);
        String phoneNumber = askInput("Quel est le téléphone du client ?", String.class);
        return new Customer(lastName, firstName, phoneNumber);
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
        do {
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
        } while (true);
    }
}
