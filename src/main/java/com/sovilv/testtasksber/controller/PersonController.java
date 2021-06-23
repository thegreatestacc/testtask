package com.sovilv.testtasksber.controller;

import com.sovilv.testtasksber.entity.Person;
import com.sovilv.testtasksber.service.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody @Validated Person person) {
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        personService.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
