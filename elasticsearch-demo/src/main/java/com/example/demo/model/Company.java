package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "layoffs_company",createIndex = true)
public class Company {

    @Id
    @Field(type = FieldType.Text)
    private String id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Text)
    private String layoffs_date;

    @Field(type = FieldType.Text)
    private String remarks;

    @Field(type = FieldType.Text)
    private String source;
}
