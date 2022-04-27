package com.example.demo.repository;

import com.example.demo.model.Company;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ESCompanyRepository extends ElasticsearchRepository<Company, String> {

    List<Company> findCompanyByNameOrRemarks(String name, String remarks);

    @Highlight(fields = {
            @HighlightField(name = "name"),
            @HighlightField(name = "remarks")
    })
    @Query("{\"match\":{\"name\":\"?0\"}}")
    SearchHits<Company> find(String keyword);
}
