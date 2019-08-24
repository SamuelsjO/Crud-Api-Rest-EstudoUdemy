package br.com.crudApiRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crudApiRest.converter.DozerConverter;
import br.com.crudApiRest.data.model.Person;
import br.com.crudApiRest.data.vo.PersonVO;
import br.com.crudApiRest.execption.ResourceNotFoundExecption;
import br.com.crudApiRest.repository.PersonRepository;


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
		Person entity = repository.findById(person.getKey())
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
