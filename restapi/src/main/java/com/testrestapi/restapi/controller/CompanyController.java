package com.testrestapi.restapi.controller;

import com.testrestapi.restapi.model.Company;
import com.testrestapi.restapi.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping("/company")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/company/{id}")
    public Optional<Company> getCompany(@PathVariable int id){
        return companyService.getCompany(id);
    }

    @PostMapping("/company")
    public Company createCompany(@RequestBody Company company){
        return companyService.createCompany(company);
    }

    @PutMapping("/company")
    public Company updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/company/{id}")
    public void deleteCompany(@PathVariable int id){
        companyService.deleteCompany(id);
    }
}
