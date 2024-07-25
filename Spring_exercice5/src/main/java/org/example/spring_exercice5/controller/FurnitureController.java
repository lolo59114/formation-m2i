package org.example.spring_exercice5.controller;

import jakarta.validation.Valid;
import org.example.spring_exercice5.entity.CartItem;
import org.example.spring_exercice5.entity.Furniture;
import org.example.spring_exercice5.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FurnitureController {

    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/furniture")
    public String furnitureList(Model model) {
        model.addAttribute("furnitures", furnitureService.getAllFurnitures());
        model.addAttribute("cartItem", new CartItem());
        return "furniture/list";
    }

    @GetMapping("/furniture/form")
    public String furnitureForm(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "furniture/form";
    }

    @PostMapping("/furniture/form")
    public String furnitureFormSubmit(@Valid @ModelAttribute("furniture") Furniture furniture, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "furniture/form";
        }
        furnitureService.saveFurniture(furniture);
        return "redirect:/furniture";
    }

    @GetMapping("/furniture/update")
    public String furnitureUpdate(@RequestParam("id") Long id, Model model) {
        model.addAttribute("furniture", furnitureService.getFurnitureById(id));
        return "furniture/form";
    }

    @GetMapping("/furniture/delete")
    public String furnitureDelete(@RequestParam("id") Long id) {
        furnitureService.deleteFurnitureById(id);
        return "redirect:/furniture";
    }

}
