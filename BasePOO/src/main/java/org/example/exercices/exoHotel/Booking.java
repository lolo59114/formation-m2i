package org.example.exercices.exoHotel;

import java.util.List;

public class Booking {
    private int id;
    private static int bookingNbr = 0;
    private BookingState bookingState;
    private List<Room> rooms;
    private Customer customer;

    public Booking(BookingState bookingState, List<Room> rooms, Customer customer) {
        this.id = ++bookingNbr;
        this.bookingState = bookingState;
        this.rooms = rooms;
        this.customer = customer;
    }
}
