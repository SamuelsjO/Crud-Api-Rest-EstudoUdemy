package br.com.crudApiRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		var entity = DozerConverter.parseObject(personVO, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public Page<PersonVO> findPersonByName(String firsName, Pageable pageable) {
		var page = repository.findPersonByName(firsName, pageable);
		return page.map(this::convertToPersonVO);
	}

	public Page<PersonVO> findAll(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToPersonVO);
	}
	private PersonVO convertToPersonVO(Person entity) {
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	
	public PersonVO findById(Long id) {

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
		
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}	
	
	@Transactional
	public PersonVO disablePerson(Long id) {

		repository.disablePersons(id);
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
				
		repository.delete(entity);
	}
}
