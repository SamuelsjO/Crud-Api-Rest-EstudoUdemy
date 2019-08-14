package com.calculatorapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calculatorapirest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
