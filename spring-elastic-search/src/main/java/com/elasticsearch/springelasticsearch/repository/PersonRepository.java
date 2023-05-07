package com.elasticsearch.springelasticsearch.repository;

import com.elasticsearch.springelasticsearch.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableElasticsearchRepositories
@Repository
public interface PersonRepository extends ElasticsearchRepository<Person,String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"firstname\": \"?0\"}}]}}")
    List<Person> getByCustomQuery(String search);
    List<Person> findByFirstnameLikeOrLastnameLike(String firstname,String lastname);
    List<Person> findAll();


}
