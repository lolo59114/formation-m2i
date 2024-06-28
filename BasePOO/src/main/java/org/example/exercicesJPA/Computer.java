package org.example.exercicesJPA;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imac;
    @Column(name="creation_date")
    private LocalDate creationDate;

    public Computer(String imac, LocalDate now) {
        this.imac = imac;
        this.creationDate = now;
    }
}
