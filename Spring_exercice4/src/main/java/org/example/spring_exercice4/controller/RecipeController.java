package org.example.spring_exercice4.controller;

import jakarta.validation.Valid;
import org.example.spring_exercice4.model.Recipe;
import org.example.spring_exercice4.service.CategoryService;
import org.example.spring_exercice4.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("")
    public String recipeList(Model model) {
        model.addAttribute("recipes", recipeService.getAll());
        return "recipe/list";
    }

    @GetMapping("/form")
    public String recipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", recipeService.getCategoryService().getAll());
        return "recipe/form";
    }

    @PostMapping(value ="/form")
    public String recipeFormSubmit(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", recipeService.getCategoryService().getAll());
            return "recipe/form";
        }

        if(recipe.getId() != null && recipe.getId() > 0) {
            recipeService.update(recipe);
        } else {
            recipeService.create(recipe);
        }

        return "redirect:/recipe";
    }

    @PostMapping(value = "/form", params = {"addIngredient"})
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
        model.addAttribute("categories", recipeService.getCategoryService().getAll());
        return "/recipe/form";
    }

    @PostMapping(value = "/form", params = {"removeIngredient"})
    public String removeIngredient(Recipe recipe, BindingResult bindingResult, String removeIngredient, Model model){
        recipe.getIngredients().remove(Integer.parseInt(removeIngredient));
        model.addAttribute("categories", recipeService.getCategoryService().getAll());
        return "/recipe/form";
    }

    @GetMapping("/detail/{id}")
    public String recipeDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("recipe", recipeService.getById(id));
        return "recipe/detail";
    }

    @GetMapping("/update/{id}")
    public String recipeUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("recipe", recipeService.getById(id));
        model.addAttribute("categories", recipeService.getCategoryService().getAll());
        return "recipe/form";
    }

    @GetMapping("/delete/{id}")
    public String recipeDelete(@PathVariable("id") Long id) {
        recipeService.delete(recipeService.getById(id));
        return "redirect:/recipe";
    }
}
