package com.calculatorapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calculatorapirest.data.model.Books;


@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{

}
