package org.example.spring_exercice2.service;

import org.example.spring_exercice2.model.Product;
import org.example.spring_exercice2.util.Category;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Primary
public class ProductService implements BaseProductService{
    List<Product> products;

    public ProductService() {
        this.products = List.of(
                Product.builder().idProduct(UUID.randomUUID()).name("Burger").category(Category.FOOD).price(14).build(),
                Product.builder().idProduct(UUID.randomUUID()).name("Frites").category(Category.FOOD).price(5).build(),
                Product.builder().idProduct(UUID.randomUUID()).name("Calculette").category(Category.ELECTRONIC).price(20).build(),
                Product.builder().idProduct(UUID.randomUUID()).name("robot").category(Category.ELECTRONIC).price(30).build()
        );
    }

    @Override
    public Product getProductById(UUID id) {
        return products.stream().filter(p -> p.getIdProduct().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return products.stream().filter(p -> p.getCategory() == category).toList();
    }

    @Override
    public List<Product> getProductsByMaxPrice(double maxPrice) {
        return products.stream().filter(p -> p.getPrice() <= maxPrice).toList();
    }

    public List<Product> compare(List<Product> products1, List<Product> products2) {
        return products1.stream().filter(products2::contains).toList();
    }
}
