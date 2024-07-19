package org.example.spring_exercice2.service;

import org.example.spring_exercice2.model.Product;
import org.example.spring_exercice2.util.Category;

import java.util.List;
import java.util.UUID;

public interface BaseProductService {
    Product getProductById(UUID id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Category category);
    List<Product> getProductsByMaxPrice(double maxPrice);
    List<Product> compare(List<Product> products1, List<Product> products2);
}
