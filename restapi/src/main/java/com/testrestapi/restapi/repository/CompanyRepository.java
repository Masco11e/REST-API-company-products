package com.testrestapi.restapi.repository;

import com.testrestapi.restapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {}