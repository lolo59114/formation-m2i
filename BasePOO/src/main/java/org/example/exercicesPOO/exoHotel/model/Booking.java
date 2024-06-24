package org.example.exercicesPOO.exoHotel.model;

import org.example.exercicesPOO.exoHotel.enums.BookingState;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final int id;
    private static int bookingNbr = 0;
    private BookingState bookingState;
    private List<Room> rooms;
    private Customer customer;

    public Booking() {
        this.id = ++bookingNbr;
        this.bookingState = BookingState.CURRENT;
        this.rooms = new ArrayList<>();
        this.customer = null;
    }

    public BookingState getBookingState() {
        return bookingState;
    }

    public void setBookingState(BookingState bookingState) {
        this.bookingState = bookingState;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {}

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    private String getStateStringValue(BookingState state) {
        String stateString = "";
        switch (state) {
            case CURRENT: stateString = "en cours";
            case PLANNED: stateString = "planifiée";
            case FINISHED: stateString = "finie";
            case CANCELLED: stateString = "annulée";
        }
        return stateString;
    }

    @Override
    public String toString() {
        return "\t- Réservation n°" + id + ": " +
                "bookingState=" + getStateStringValue(bookingState) +
                ", rooms=" + rooms +
                ", customer=" + customer +
                '}';
    }
}
