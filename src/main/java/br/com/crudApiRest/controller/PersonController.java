package br.com.crudApiRest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

import br.com.crudApiRest.data.vo.PersonVO;
import br.com.crudApiRest.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "Person Endpoint", description = "Description for person", tags = {"PersonEndpoint"})
@Api(tags = "Person EndPoint")
@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personServices;

	@ApiOperation(value = "Find All people recorded")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<PersonVO> findAll() {
		List<PersonVO> persons = personServices.findAll();
		persons.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
						)
					);
		return persons;
	}

	@ApiOperation(value = "Find people by id")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO findById(@PathVariable("id") Long id) {
		PersonVO personVO = personServices.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}

	@ApiOperation(value = "Create person") 
	@PostMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml", "application/x-yaml" })
	public PersonVO create(@RequestBody PersonVO person) {
		PersonVO personVO = personServices.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	@ApiOperation(value = "Update person") 
	@PutMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml", "application/x-yaml" })
	public PersonVO update(@RequestBody PersonVO PersonVO) {
		PersonVO personVO = personServices.update(PersonVO);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	@ApiOperation(value = "Delete person by ID") 
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personServices.delete(id);
		return ResponseEntity.ok().build();
	}
}
