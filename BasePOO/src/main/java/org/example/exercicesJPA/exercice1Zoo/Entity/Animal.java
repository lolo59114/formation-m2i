package org.example.exercicesJPA.exercice1Zoo.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.exercicesJPA.exercice1Zoo.Util.Diet;

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

    private String name;
    private int age;

    @Column(name="regime_alim", nullable = false)
    @Enumerated
    Diet regimeAlim;

    @Column(name="date_arrivee")
    LocalDate dateArrivee;

}
