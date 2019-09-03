package br.com.crudApiRest.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundExecption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MyFileNotFoundExecption(String exception) {
		super(exception);
	}
	
	public MyFileNotFoundExecption(String exception, Throwable cause) {
		super(exception, cause);
	}

}
