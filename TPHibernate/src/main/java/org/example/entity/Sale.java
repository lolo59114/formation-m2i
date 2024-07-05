package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.util.SaleState;

import java.time.LocalDate;
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

    @Column(name="total_price")
    double totalPrice;

    SaleState state;

    LocalDate saleDate;

    @OneToMany(mappedBy = "id.sale", fetch = FetchType.LAZY)
    List<SaleLine> saleLines;

    public Sale() {
        this.state = SaleState.ON_GOING;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", totalPrice=" + totalPrice +
                ", state=" + state +
                ", saleDate=" + saleDate +
                '}';
    }
}
