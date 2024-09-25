package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class ArticleElectronic extends Article {
    @Column(name="duration_in_minutes", nullable = false)
    private long durationInMinutes;

    @Override
    public String toString() {
        return "ArticleElectronic{" +
                super.toString() +
                ", durationInMinutes=" + durationInMinutes +
                "} ";
    }
}
