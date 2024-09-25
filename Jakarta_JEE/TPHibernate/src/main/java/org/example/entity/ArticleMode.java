package org.example.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.util.CategoryMode;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class ArticleMode extends Article{
    private CategoryMode category;
    private String taille;

    @Override
    public String toString() {
        return "ArticleMode{" +
                super.toString() +
                ", category=" + category +
                ", taille='" + taille + '\'' +
                "}";
    }
}
