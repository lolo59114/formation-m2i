package org.example.exercicesJPA.exercice2Billeterie.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercicesJPA.exercice2Billeterie.Util.TicketType;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_id")
    private int id;

    @Column(name="place_number")
    private int placeNumber;

    private TicketType type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public String toStringEvent() {
        return "Ticket{" +
                "placeNumber=" + placeNumber +
                ", type=" + type +
                ", customer=" + customer +
                '}';
    }

    public String toStringCustomer() {
        return "Ticket{" +
                "placeNumber=" + placeNumber +
                ", type=" + type +
                ", event=" + event +
                '}';
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "placeNumber=" + placeNumber +
                ", type=" + type +
                ", event=" + event +
                ", customer=" + customer +
                '}';
    }
}
