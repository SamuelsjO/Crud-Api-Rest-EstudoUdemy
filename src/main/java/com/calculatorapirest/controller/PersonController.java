package com.calculatorapirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculatorapirest.data.vo.PersonVO;
import com.calculatorapirest.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personServices;

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml"})
	public List<PersonVO> findAll() {
		return personServices.findAll();
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id) {
		return personServices.findById(id);
	}

	@PostMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO personVO) {
		return personServices.create(personVO);
	}

	@PutMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO PersonVO) {
		return personServices.update(PersonVO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personServices.delete(id);
		return ResponseEntity.ok().build();
	}
}
