package org.example.spring_exercice4.controller;

import jakarta.validation.Valid;
import org.example.spring_exercice4.model.Category;
import org.example.spring_exercice4.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "category/list";
    }

    @GetMapping("/category/form")
    public String categoryForm(Model model) {
        model.addAttribute("categorie", new Category());
        return "category/form";
    }

    @PostMapping("/category/form")
    public String categoryFormSubmit(@Valid @ModelAttribute("categorie") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/form";
        }
        if (category.getId() != null && category.getId() > 0) {
            categoryService.update(category);
        } else {
            categoryService.create(category);
        }
        return "redirect:/category";
    }

    @GetMapping("/category/update/{id}")
    public String categoryUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categorie", categoryService.getById(id));
        return "category/form";
    }

    @GetMapping("/category/delete/{id}")
    public String categoryDelete(@PathVariable("id") Long id) {
        categoryService.delete(categoryService.getById(id));
        return "redirect:/category";
    }
}
