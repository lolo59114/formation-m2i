package org.example.spring_exercice4.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    @NotEmpty(message = "Le nom de la catégorie ne doit pas être vide")
    private String name;
    private String description;
}
