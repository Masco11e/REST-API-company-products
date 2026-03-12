package com.testrestapi.restapi.controller;

import com.testrestapi.restapi.model.Product;
import com.testrestapi.restapi.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/products/company/{companyId}")
    public List<Product> getProductsByCompany(@PathVariable int companyId){
        return productService.getProductsByCompany(companyId);
    }

    @GetMapping("/products/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name){
        return productService.getProductsByName(name);
    }

    @GetMapping("/products/companyname/{companyName}")
    public List<Product> getProductsByCompanyName(@PathVariable String companyName) {
        return productService.getProductsByCompanyName(companyName);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
}