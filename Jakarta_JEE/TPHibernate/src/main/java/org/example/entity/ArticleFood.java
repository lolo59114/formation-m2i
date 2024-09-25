package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class ArticleFood extends Article {
    @Column(name="expiration_date")
    private LocalDate expirationDate;

    @Override
    public String toString() {
        return "ArticleFood{" +
                super.toString() +
                ", expirationDate=" + expirationDate +
                "} ";
    }
}
