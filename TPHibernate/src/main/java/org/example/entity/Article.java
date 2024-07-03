package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Article {
    @Id
    @GeneratedValue
    @Column(name="id_article")
    protected long idArticle;

    @Column(nullable = false)
    protected String description;

    @Column(nullable = false)
    protected double price;

    @Column(name="quantity_available")
    protected int quantityAvailable;

    @Column(name="restock_date")
    protected LocalDate restockDate;

//    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
//    protected List<SaleLine> saleLines;

    @Override
    public String toString() {
        return "id=" + idArticle +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityAvailable=" + quantityAvailable +
                ", restockDate=" + restockDate;
    }
}
