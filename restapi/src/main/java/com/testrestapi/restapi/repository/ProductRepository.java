package com.testrestapi.restapi.repository;

import com.testrestapi.restapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCompanyId(int companyId);
    List<Product> findByName(String name);
    @Query("SELECT products FROM Product products JOIN Company company ON products.companyId = company.id WHERE company.name = :name")
    List<Product> findByCompanyName(@Param("name") String name);
}
