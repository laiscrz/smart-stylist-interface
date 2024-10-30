package com.leadtech.SmartStylist.controller;

import com.leadtech.SmartStylist.model.Product;
import com.leadtech.SmartStylist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String viewProductsPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/list"; // Nome da view para a lista de produtos
    }

    @GetMapping("/details/{id}")
    public String viewProductDetailsPage(@PathVariable String id, Model model) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
        model.addAttribute("product", product);
        return "product/details"; // Nome da nova view
    }

    @GetMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/form"; // Nome do formulário para criar/editar produtos
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable String id, Model model) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
        model.addAttribute("product", product);
        return "product/form";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable String id, @ModelAttribute("product") Product product) {
        if (productService.findById(id).isPresent()) {
            product.setId(id);
            productService.update(id, product);
        }
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        if (productService.findById(id).isEmpty()) {
            return "redirect:/products";
        }
        productService.deleteById(id);
        return "redirect:/products";
    }
}
