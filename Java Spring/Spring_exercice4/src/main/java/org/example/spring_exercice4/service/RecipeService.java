package org.example.spring_exercice4.service;

import lombok.Getter;
import org.example.spring_exercice4.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class RecipeService implements ICRUDService<Recipe>{
    private List<Recipe> recipes;
    private Long recipeCounter;
    private final CategoryService categoryService;

    public RecipeService(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.recipes = new ArrayList<>();
        this.recipeCounter = 1L;
    }

    @Override
    public void create(Recipe recipe) {
        recipe.setId(recipeCounter++);
        recipe.setCategory(categoryService.getById(recipe.getCategory().getId()));
        recipes.add(recipe);
    }

    @Override
    public void update(Recipe recipe) {
        Recipe recipeUpdate = getById(recipe.getId());
        int index = recipes.indexOf(recipeUpdate);
        recipe.setCategory(categoryService.getById(recipe.getCategory().getId()));
        recipes.set(index, recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        recipes.remove(recipe);
    }

    @Override
    public Recipe getById(Long id) {
        return recipes.stream().filter(recipe -> recipe.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Recipe> getAll() {
        return recipes;
    }
}
