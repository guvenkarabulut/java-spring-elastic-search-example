package com.elasticsearch.springelasticsearch.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
@Document(indexName = "persons")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private String id;
    @Field(name = "firstname",type = FieldType.Text)
    private String firstname;
    @Field(name = "lastname",type = FieldType.Text)
    private String lastname;
    @Field(name = "adress",type = FieldType.Text)
    private String adress;
    @Field(name = "birth_date",type = FieldType.Date)
    private Date birthDate;
}
