package org.example.exercicesPOO.exoHotel.model;

import org.example.exercicesPOO.exoHotel.enums.RoomState;

public class Room {
    private int numero;
    private RoomState roomState;
    private final int bedNbr;
    private double cost;

    public Room(int numero, RoomState roomState, int bedNbr, double cost) {
        this.numero = numero;
        this.roomState = roomState;
        this.bedNbr = bedNbr;
        this.cost = cost;
    }

    public RoomState getRoomState() {
        return roomState;
    }

    public void setRoomState(RoomState roomState) {
        this.roomState = roomState;
    }

    public int getNumero() {
        return numero;
    }

    public int getBedNbr() {
        return bedNbr;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "\tab- Chambre n°" +
                "numero : " + numero +
                ", roomState=" + roomState.toString() +
                ", Nombre de lits: " + bedNbr +
                ", Prix: " + cost + " €";
    }
}
