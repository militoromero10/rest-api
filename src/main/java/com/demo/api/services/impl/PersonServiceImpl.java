package com.demo.api.services.impl;

import com.demo.api.exception.MalformedBodyException;
import com.demo.api.exception.ResourceNotFoundException;
import com.demo.api.model.Person;
import com.demo.api.repositories.PersonRepository;
import com.demo.api.services.PersonService;
import com.demo.api.v1.controller.PersonController;
import com.demo.api.v1.dto.PersonDTO;
import com.demo.api.v1.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonMapper personMapper;
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    private PersonDTO saveOrUpdate(Person person) {
        Person personSaved = personRepository.save(person);
        PersonDTO returnDto = personMapper.personToPersonDTO(personSaved);
        returnDto.setPersonUrl(getPersonUrl(personSaved.getId()));
        return returnDto;
    }

    private String getPersonUrl(Long id) {
        return PersonController.BASE_URL + "/" + id;
    }

    @Override
    public List<PersonDTO> findAll() {
        return personRepository
                .findAll()
                .stream()
                .map(person -> {
                    PersonDTO personDTO = personMapper.personToPersonDTO(person);
                    personDTO.setPersonUrl(getPersonUrl(person.getId()));
                    return personDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::personToPersonDTO)
                .map(personDTO -> {
                    personDTO.setPersonUrl(getPersonUrl(id));
                    return personDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        PersonDTO returnPerson;
        try{
            returnPerson = saveOrUpdate(personMapper.personDTOToPerson(personDTO));
        }catch ( Exception e ){
            throw new MalformedBodyException();
        }
        return returnPerson;
    }

    @Override
    public PersonDTO updatePerson(PersonDTO personDTO) {
        Person person = personMapper.personDTOToPerson(personDTO);
        person.setId(personDTO.getId());
        PersonDTO returnPerson;
        try{
            returnPerson = saveOrUpdate(person);
        }catch ( Exception e ){
            throw new MalformedBodyException();
        }
        return returnPerson;
    }

    @Override
    public PersonDTO patchPerson(PersonDTO personDTO) {
        return personRepository.findById(personDTO.getId()).map(person -> {
            if(personDTO.getFirstName()!= null)
                person.setFirstName(personDTO.getFirstName());
            if(personDTO.getLastName()!= null)
                person.setLastName(personDTO.getLastName());
            if(personDTO.getBirthdate()!= null)
                person.setBirthdate(personDTO.getBirthdate());
            if(personDTO.getEmail()!= null)
                person.setEmail(personDTO.getEmail());
            if(personDTO.getNuip()!=null)
                person.setNuip(personDTO.getNuip());
            if(personDTO.getObservation()!=null)
                person.setObservation(personDTO.getObservation());

            PersonDTO returnDto = personMapper.personToPersonDTO(personRepository.save(person));
            returnDto.setPersonUrl(getPersonUrl(personDTO.getId()));

            returnDto.setPersonUrl(getPersonUrl(returnDto.getId()));

            return returnDto;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deletePersonById(Long id) {
        try{
            personRepository.deleteById(id);
        }catch (Exception e){
            throw new ResourceNotFoundException();
        }
    }
}
