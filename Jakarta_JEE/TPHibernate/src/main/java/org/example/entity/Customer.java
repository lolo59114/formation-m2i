package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_customer")
    long idCustomer;

    String name;

    String email;

    @OneToMany(mappedBy = "customer")
    List<Sale> salesHistory;

    public String toStringSaleHistory() {
        StringBuilder sb = new StringBuilder();
        for (Sale sale : salesHistory) {
            sb.append("\t")
                    .append(sale)
                    .append("\n")
                    .append(sale.toStringSaleLines());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}