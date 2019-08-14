package com.calculatorapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculatorapirest.execption.ResourceNotFoundExecption;
import com.calculatorapirest.model.Person;
import com.calculatorapirest.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;

	public Person Create(Person person) {

		return repository.save(person);
	}

	public List<Person> findAll() {

		return repository.findAll();
	}

	public Person findById(Long id) {

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
	}

	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}

	public void delete(Long id) {

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));

		repository.delete(entity);
	}

}
