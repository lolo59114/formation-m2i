package org.example.spring_exercice4.controller;

import jakarta.validation.Valid;
import org.example.spring_exercice4.model.Category;
import org.example.spring_exercice4.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "category/list";
    }

    @GetMapping("/form")
    public String categoryForm(Model model) {
        model.addAttribute("categorie", new Category());
        return "category/form";
    }

    @PostMapping("/form")
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

    @GetMapping("/update/{id}")
    public String categoryUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categorie", categoryService.getById(id));
        return "category/form";
    }

    @GetMapping("/delete/{id}")
    public String categoryDelete(@PathVariable("id") Long id) {
        categoryService.delete(categoryService.getById(id));
        return "redirect:/category";
    }
}
