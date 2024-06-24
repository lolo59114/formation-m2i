package org.example.exercicesPOO.exoHotel.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int id;
    private static int customerNbr = 0;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Booking> bookings;

    public Customer(String firstName, String lastName, String phoneNumber) {
        this.id = ++customerNbr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        bookings = new ArrayList<>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public String toString() {
        return "\t- " + id + " : " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'';
    }
}
