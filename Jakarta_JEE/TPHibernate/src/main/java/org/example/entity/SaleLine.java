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
@Table(name = "sale_line")
public class SaleLine {
    @EmbeddedId
    private SaleLinePK id = new SaleLinePK();

    private int quantity;

    @Column(name="sub_total_price")
    private double subTotalPrice;

    @Override
    public String toString() {
        return "SaleLine{" + id +
                ", quantity=" + quantity +
                ", subTotalPrice=" + subTotalPrice +
                '}';
    }
}
