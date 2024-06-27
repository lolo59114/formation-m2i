package org.example.exercicesJPA.exercice2Billeterie.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id")
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name="place_number")
    private int placeNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Ticket> tickets;

    @Override
    public String toString() {
        List<String> ticketString = tickets.stream().map(Ticket::toStringEvent).toList();
        return "Event{" +
                "placeNumber=" + placeNumber +
                ", startDate=" + startDate +
                ", address=" + address +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", tickets=" + ticketString +
                '}';
    }
}
