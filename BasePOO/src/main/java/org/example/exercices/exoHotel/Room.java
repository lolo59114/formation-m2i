package org.example.exercices.exoHotel;

public class Room {
    private int numero;
    private RoomState roomState;
    private int bedNbr;
    private double cost;

    public Room(int numero, RoomState roomState, int bedNbr, double cost) {
        this.numero = numero;
        this.roomState = roomState;
        this.bedNbr = bedNbr;
        this.cost = cost;
    }
}
