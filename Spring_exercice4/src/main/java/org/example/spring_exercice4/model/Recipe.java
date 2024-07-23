package org.example.spring_exercice4.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private Long id;
    @NotEmpty(message = "Le nom de la recette ne peut pas être vide")
    private String name;
    @NotEmpty(message = "La recette doit comporter au moins un ingrédiant")
    private List<String> ingredients;
    @NotEmpty(message = "La recette doit comporter des instructions")
    private String instructions;
    private Category category;
    @NotNull(message = "La recette doit appartenir à une catégorie")
    private Long categoryId;
}
