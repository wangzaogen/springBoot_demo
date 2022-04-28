package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.repository.ESCompanyRepository;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ESCompanyRepository esCompanyRepository;

    @PostMapping("/addCompany")
    public String addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return "ok";
    }

    @PostMapping("/updateCompany")
    public String updateompany(@RequestBody Company company){
        Optional<Company> co =  esCompanyRepository.findById(company.getId());
        if (null == co.get()) {
            return "company is not exist";
        }
        companyService.addCompany(company);
        return "ok";
    }


    @GetMapping("/getCampany/{key}")
    public SearchHits<Company> getCampany(@PathVariable("key") String key){
        return companyService.searchCompanyHits(key);
    }

}
