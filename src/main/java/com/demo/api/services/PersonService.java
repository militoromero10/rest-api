package com.demo.api.services;


import com.demo.api.v1.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    List<PersonDTO> findAll();

    PersonDTO getPersonById(Long id);

    PersonDTO createPerson(PersonDTO personDTO);

    PersonDTO updatePerson(PersonDTO personDTO);

    PersonDTO patchPerson(PersonDTO personDTO);

    void deletePersonById(Long id);

}
