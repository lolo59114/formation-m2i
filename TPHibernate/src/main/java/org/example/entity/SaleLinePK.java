package org.example.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SaleLinePK implements Serializable {
    @ManyToOne
    @JoinColumn(name="id_sale")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @Override
    public String toString() {
        return "sale=" + sale +
                ", article=" + article +
                '}';
    }
}
