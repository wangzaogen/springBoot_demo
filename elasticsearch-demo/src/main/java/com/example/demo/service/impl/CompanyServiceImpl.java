package com.example.demo.service.impl;

import com.example.demo.model.Company;
import com.example.demo.repository.ESCompanyRepository;
import com.example.demo.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private ESCompanyRepository companyRepository;

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> searchCompany(String keyWord) {
        return companyRepository.findCompanyByNameOrRemarks(keyWord, keyWord);
    }

    @Override
    public SearchHits<Company> searchCompanyHits(String keyWord) {
        return companyRepository.find(keyWord);
    }
}
