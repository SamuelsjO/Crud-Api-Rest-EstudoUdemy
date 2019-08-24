package br.com.crudApiRest.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExecption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExecption(String exception) {
		super(exception);
	}

}
