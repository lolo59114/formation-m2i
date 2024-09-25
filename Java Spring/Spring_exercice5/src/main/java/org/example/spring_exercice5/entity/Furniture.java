package org.example.spring_exercice5.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_furniture")
    private Long id;
    @NotEmpty
    private String name;
    private String description;
    @Min(0)
    private double price;
    @Min(0)
    private int stock;
    @OneToOne(mappedBy = "furniture", cascade = CascadeType.REMOVE)
    private CartItem cartItem;
}
