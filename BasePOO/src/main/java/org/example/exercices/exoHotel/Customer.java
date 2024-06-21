package org.example.exercices.exoHotel;

public class Customer {
    private int id;
    private static int customerNbr = 0;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Customer(String firstName, String lastName, String phoneNumber) {
        this.id = ++customerNbr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\t- Customer : " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'';
    }
}
