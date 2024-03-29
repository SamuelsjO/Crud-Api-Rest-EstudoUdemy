package br.com.crudApiRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crudApiRest.converter.DozerConverter;
import br.com.crudApiRest.data.model.Books;
import br.com.crudApiRest.data.vo.BooksVO;
import br.com.crudApiRest.execption.ResourceNotFoundExecption;
import br.com.crudApiRest.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	BooksRepository bookRepository;
	
		
	public BooksVO create(BooksVO BooksVO) {
		Books entity = DozerConverter.parseObject(BooksVO, Books.class);
		BooksVO vo = DozerConverter.parseObject(bookRepository.save(entity), BooksVO.class);
		return vo;
	}
	
	public List<BooksVO> findAll() {
		return DozerConverter.parseListObjects(bookRepository.findAll(), BooksVO.class);
	}	
	
	public BooksVO findById(Long id) {
		Books entity = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
		return DozerConverter.parseObject(entity, BooksVO.class);
	}
		
	public BooksVO update(BooksVO books) {
		Books entity = bookRepository.findById(books.getKey())
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
		
		entity.setAuthor(books.getAuthor());
		entity.setLaunchDate(books.getLaunchDate());
		entity.setPrice(books.getPrice());
		entity.setTitle(books.getTitle());
		
		BooksVO vo = DozerConverter.parseObject(bookRepository.save(entity), BooksVO.class);
		return vo;
	}	

	public void delete(Long id) {
		Books entity = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));

		bookRepository.delete(entity);
	}
}
