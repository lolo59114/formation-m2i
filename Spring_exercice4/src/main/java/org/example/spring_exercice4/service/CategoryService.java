package org.example.spring_exercice4.service;

import org.example.spring_exercice4.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICRUDService<Category> {
    private List<Category> categories;
    private Long categorieCounter;
    public CategoryService() {
        categories = new ArrayList<>();
        categorieCounter = 1L;
        create(Category.builder().name("Categ1").description("une description pour une catégorie 1").build());
        create(Category.builder().name("Categ2").description("une description pour une catégorie 2").build());
        create(Category.builder().name("Categ3").description("une description pour une catégorie 3").build());
    }

    @Override
    public void create(Category category) {
        category.setId(categorieCounter++);
        categories.add(category);
    }

    @Override
    public void update(Category category) {
        Category categoryUpdate = getById(category.getId());
        int index = categories.indexOf(categoryUpdate);
        categories.set(index, category);
    }

    @Override
    public void delete(Category category) {
        categories.remove(category);
    }

    @Override
    public Category getById(Long id) {
        return categories.stream().filter(category -> category.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }
}
