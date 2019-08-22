package com.calculatorapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculatorapirest.converter.DozerConverter;
import com.calculatorapirest.data.model.Person;
import com.calculatorapirest.data.vo.PersonVO;
import com.calculatorapirest.execption.ResourceNotFoundExecption;
import com.calculatorapirest.repository.PersonRepository;


@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	
		
	public PersonVO create(PersonVO personVO) {
		Person entity = DozerConverter.parseObject(personVO, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}	
	
	public PersonVO findById(Long id) {

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
		
	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
				
		repository.delete(entity);
	}
}
