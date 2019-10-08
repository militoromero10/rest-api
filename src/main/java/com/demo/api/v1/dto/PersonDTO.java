package com.demo.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("identification_number")
    private Long nuip;

    @JsonProperty("birth_date")
    private LocalDate birthdate;

    private String observation;
    private String email;

    @JsonProperty("person_url")
    private String personUrl;

}
