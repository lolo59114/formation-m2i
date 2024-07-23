package org.example.spring_exercice4.controller;

import jakarta.validation.Valid;
import org.example.spring_exercice4.model.Recipe;
import org.example.spring_exercice4.service.CategoryService;
import org.example.spring_exercice4.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class RecipeController {
    private final RecipeService recipeService;
    private final CategoryService categoryService;
    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/recipe")
    public String recipeList(Model model) {
        model.addAttribute("recipes", recipeService.getAll());
        return "recipe/list";
    }

    @GetMapping("/recipe/form")
    public String recipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", categoryService.getAll());
        return "recipe/form";
    }

    @PostMapping(value ="/recipe/form")
    public String recipeFormSubmit(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult) {
        System.out.println("je passe");
        if (bindingResult.hasErrors()) {
            return "recipe/form";
        }

        if(recipe.getId() != null && recipe.getId() > 0) {
            recipe.setCategory(categoryService.getById(recipe.getCategoryId()));
            recipeService.update(recipe);
        } else {
            recipe.setCategory(categoryService.getById(recipe.getCategoryId()));
            recipeService.create(recipe);
        }

        return "redirect:/recipe";
    }

    @PostMapping(value = "/recipe/form", params = {"addIngredient"})
    public String addIngredient(Recipe recipe, BindingResult bindingResult, Model model) {
        if(recipe != null) {
            if(recipe.getIngredients() == null){
                List<String> ingredients = new ArrayList<>();
                ingredients.add("");
                recipe.setIngredients(ingredients);
            } else {
                recipe.getIngredients().add("");
            }
        }
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryService.getAll());
        return "/recipe/form";
    }

    @PostMapping(value = "/recipe/form", params = {"removeIngredient"})
    public String removeIngredient(Recipe recipe, BindingResult bindingResult, String removeIngredient, Model model){
        recipe.getIngredients().remove(Integer.parseInt(removeIngredient));
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryService.getAll());
        return "/recipe/form";
    }

    @GetMapping("/recipe/update/{id}")
    public String recipeUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("recipe", recipeService.getById(id));
        return "recipe/form";
    }

    @GetMapping("/recipe/delete/{id}")
    public String recipeDelete(@PathVariable("id") Long id) {
        recipeService.delete(recipeService.getById(id));
        return "redirect:/recipe";
    }
}
