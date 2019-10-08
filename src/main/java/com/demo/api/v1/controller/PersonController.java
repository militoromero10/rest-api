package com.demo.api.v1.controller;

import com.demo.api.services.PersonService;
import com.demo.api.v1.dto.PersonDTO;
import com.demo.api.v1.dto.PersonListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PersonController.BASE_URL)
public class PersonController {

    public static final String BASE_URL = "/api/v1/person";
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PersonListDTO getAllPersons(){
        return new PersonListDTO(personService.findAll());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getPersonByFirstName(@PathVariable Long id){
        return personService.getPersonById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO updatePerson(@RequestBody PersonDTO personDTO){
        return personService.updatePerson(personDTO);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO patchPerson(@RequestBody PersonDTO personDTO){
        return personService.patchPerson(personDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable Long id){
        personService.deletePersonById(id);
    }
}
