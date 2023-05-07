package com.elasticsearch.springelasticsearch.controller;

import com.elasticsearch.springelasticsearch.entity.Person;
import com.elasticsearch.springelasticsearch.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search){
        List<Person> persons=personRepository.findByFirstnameLikeOrLastnameLike(search,search);
        return ResponseEntity.ok(persons);
    }
    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> persons=personRepository.findAll();
        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public  ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person newPerson = Person.builder()
                .id(UUID.randomUUID().toString())
                .firstname(person.getFirstname())
                .lastname(person.getLastname())
                .adress(person.getAdress())
                .birthDate(Calendar.getInstance().getTime())
                .build();
        return ResponseEntity.ok(personRepository.save(newPerson));
    }
}
