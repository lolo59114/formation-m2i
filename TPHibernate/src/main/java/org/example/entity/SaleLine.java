package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(SaleLinePK.class)
public class SaleLine {
    @Id
    @Column(name = "id_sale")
    private long idSale;
    @Column(name = "id_article")
    @Id
    private long idArticle;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_sale")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;

}
