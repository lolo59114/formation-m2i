package org.example.exercices.exoHotel.model;

import org.example.exercices.exoHotel.enums.BookingState;
import org.example.exercices.exoHotel.enums.RoomState;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<Customer> customers;
    private List<Room> rooms;
    private List<Booking> bookings;

    public Hotel(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        try {
            return customers.get(id-1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoomById(int id) {
        try{
            return rooms.get(id-1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        booking.setBookingState(BookingState.PLANNED);
        this.bookings.add(booking);
        for(Room room : booking.getRooms()){
            room.setRoomState(RoomState.OCCUPIED);
        }
    }
}
