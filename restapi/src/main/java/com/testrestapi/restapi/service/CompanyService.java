package com.testrestapi.restapi.service;

import com.testrestapi.restapi.model.Company;
import com.testrestapi.restapi.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Optional<Company> getCompany(int id){
        return companyRepository.findById(id);
    }

    public Company createCompany(Company company){
        return companyRepository.save(company);
    }

    public Company updateCompany(Company company){
        if(!companyRepository.existsById(company.getId())){
            throw new IllegalArgumentException("company " + company.getId() + " not exist");
        }
        return companyRepository.save(company);
    }

    public void deleteCompany(int id){
        companyRepository.deleteById(id);
    }
}
