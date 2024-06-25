package org.example.exercicesJPA.exercice1Zoo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;
    private int age;

    @Column(name="regime_alim", nullable = false)
    @Enumerated
    EnumRegimeAlim regimeAlim;

    @Column(name="date_arrivee")
    LocalDate dateArrivee;

}
