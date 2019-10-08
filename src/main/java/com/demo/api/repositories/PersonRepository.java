package com.demo.api.repositories;

import com.demo.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
