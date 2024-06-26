package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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

    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
    List<SaleLine> saleLines;

    public Sale() {
        this.state = SaleState.ON_GOING;
    }

}
