package com.example.demo.service;

import com.example.demo.model.Company;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;

public interface CompanyService {

    public void addCompany(Company company);

    public List<Company> searchCompany(String keyWord);

    public SearchHits<Company> searchCompanyHits(String keyWord);
}
