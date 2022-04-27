package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/addCompany")
    public String addBook(@RequestBody Company company){
        companyService.addCompany(company);
        return "ok";
    }


    @GetMapping("/getCampany/{key}")
    public SearchHits<Company> getCampany(@PathVariable("key") String key){
        return companyService.searchCompanyHits(key);
    }

}
