package com.testrestapi.restapi.service;

import com.testrestapi.restapi.model.Product;
import com.testrestapi.restapi.repository.CompanyRepository;
import com.testrestapi.restapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CompanyRepository companyRepository;

    public ProductService(ProductRepository productRepository,
                          CompanyRepository companyRepository) {
        this.productRepository = productRepository;
        this.companyRepository = companyRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public List<Product> getProductsByCompany(int companyId){
        return productRepository.findByCompanyId(companyId);
    }

    public List<Product> getProductsByName(String name){
        return productRepository.findByName(name);
    }

    public List<Product> getProductsByCompanyName(String companyName){
        return productRepository.findByCompanyName(companyName);
    }

    public Product createProduct(Product product){
        if(product.getName() == null || product.getName().isEmpty()){
            throw new IllegalArgumentException("product name cannot be empty");
        }
        if(!companyRepository.existsById(product.getCompanyId())){
            throw new IllegalArgumentException("company does not exist");
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        if(!productRepository.existsById(product.getId())){
            throw new IllegalArgumentException("product not found");
        }
        return productRepository.save(product);
    }

    public void deleteProduct(int id){

        if(!productRepository.existsById(id)){
            throw new IllegalArgumentException("product not found");
        }

        productRepository.deleteById(id);
    }
}