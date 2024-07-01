package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.util.SaleState;

import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sale")
    long idSale;

    SaleState state;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="Article_Sale",
    joinColumns=@JoinColumn(name="id_sale"),
    inverseJoinColumns=@JoinColumn(name="id_article"))
    List<Article> articles;

    public Sale() {
        this.state = SaleState.ON_GOING;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "state=" + state +
                ", articles=" + articles +
                ", idSale=" + idSale +
                '}';
    }
}
