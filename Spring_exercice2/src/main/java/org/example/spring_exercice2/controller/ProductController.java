package org.example.spring_exercice2.controller;

import org.example.spring_exercice2.model.Product;
import org.example.spring_exercice2.service.BaseProductService;
import org.example.spring_exercice2.util.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    private final BaseProductService baseProductService;

    public ProductController(BaseProductService baseProductService) {
        this.baseProductService = baseProductService;
    }

    @GetMapping("/")
    public String homePage() {
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
    public String searchProducts(@RequestParam(value = "category", required = false) String category, @RequestParam(value = "maxPrice", required = false) Double maxPrice, Model model) {
        System.out.println(category);
        System.out.println(maxPrice);
        List<Product> products = null;

        if(category != null && maxPrice != null) {
            products = baseProductService.compare(baseProductService.getProductsByCategory(Category.valueOf(category)), baseProductService.getProductsByMaxPrice(maxPrice));
            System.out.println("on compare : " + products.size());
        } else if (category != null) {
            products = baseProductService.getProductsByCategory(Category.valueOf(category));
            System.out.println("by Categ " + products.size());
        } else if (maxPrice != null) {
            products = baseProductService.getProductsByMaxPrice(maxPrice);
            System.out.println("by max price " + products.size());
        }

        model.addAttribute("products", products);
        return "product/list";
    }
}
