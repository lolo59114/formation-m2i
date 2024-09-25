package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Product {
    public String type;
    public String name;
    public int sellIn;
    public int quality;

    public Product(String type, String name, int sellIn, int quality) {
        this.type = type;
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
}
