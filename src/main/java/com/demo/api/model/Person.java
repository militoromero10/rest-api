package com.demo.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "dm_person")
public class Person extends BaseEntity {

    @Column(name = "first_name", length = 64, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 64, nullable = false)
    private String lastName;

    @Column(name = "document_number", nullable = false)
    private Long nuip;

    @Column(name = "birth_date",nullable = false)
    private LocalDate birthdate;

    @Lob
    @Column(name = "observation")
    private String observation;

    @Lob
    @Column(name = "email", length = 256)
    private String email;

}
