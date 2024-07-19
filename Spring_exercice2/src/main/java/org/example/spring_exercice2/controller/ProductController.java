package org.example.spring_exercice2.controller;

import org.example.spring_exercice2.model.Product;
import org.example.spring_exercice2.service.BaseProductService;
import org.example.spring_exercice2.util.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    private final BaseProductService baseProductService;

    public ProductController(BaseProductService baseProductService) {
        this.baseProductService = baseProductService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("product", new Product());
        return "home";
    }

    @GetMapping("/product/list")
    public String listProducts(Model model) {
        model.addAttribute("products", baseProductService.getAllProducts());
        return "product/list";
    }

    @GetMapping("/product/details/{id}")
    public String detailsProduct(@PathVariable UUID id, Model model) {
        model.addAttribute("product", baseProductService.getProductById(id));
        return "product/details";
    }

    @GetMapping("/product/search")
    public String searchProductsFromGet(@RequestParam(value = "category", required = false) String category, @RequestParam(value = "maxPrice", required = false) Double maxPrice, Model model) {
        List<Product> products = baseProductService.researchProduct(category, maxPrice);
        model.addAttribute("products", products);
        return "product/list";
    }

    @PostMapping("/product/search")
    public String searchProductsFromPost(@ModelAttribute Product product, Model model) {
        List<Product> products = baseProductService.researchProduct(product.getCategory() == null ? null : product.getCategory().name(), product.getPrice());
        model.addAttribute("products", products);
        return "product/list";
    }


}
