package com.calculatorapirest.controller;

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

import com.calculatorapirest.data.vo.BooksVO;
import com.calculatorapirest.services.BooksService;


@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksService booksServices;

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<BooksVO> findAll() {
		List<BooksVO> books = booksServices.findAll();
		books.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(BooksController.class).findById(p.getKey())).withSelfRel()
						)
					);
		return books;
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public BooksVO findById(@PathVariable("id") Long id) {
		BooksVO booksVO = booksServices.findById(id);
		booksVO.add(linkTo(methodOn(BooksController.class).findById(id)).withSelfRel());
		return booksVO;
	}

	@PostMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml", "application/x-yaml" })
	public BooksVO create(@RequestBody BooksVO books) {
		BooksVO booksVO = booksServices.create(books);
		booksVO.add(linkTo(methodOn(BooksController.class).findById(booksVO.getKey())).withSelfRel());
		return booksVO;
	}

	@PutMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml", "application/x-yaml" })
	public BooksVO update(@RequestBody BooksVO books) {
		BooksVO booksVO = booksServices.update(books);
		booksVO.add(linkTo(methodOn(BooksController.class).findById(books.getKey())).withSelfRel());
		return booksVO;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		booksServices.delete(id);
		return ResponseEntity.ok().build();
	}
}
