package com.demo.api.v1.mapper;

import com.demo.api.model.Person;
import com.demo.api.v1.dto.PersonDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {

    PersonDTO personToPersonDTO(Person person);
    Person personDTOToPerson(PersonDTO personDTO);

}
