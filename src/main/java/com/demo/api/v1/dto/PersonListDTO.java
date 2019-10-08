package com.demo.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonListDTO {

    List<PersonDTO> persons;
}
