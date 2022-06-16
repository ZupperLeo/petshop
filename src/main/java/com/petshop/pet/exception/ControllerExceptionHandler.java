package com.petshop.pet.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		List<String> mensagens = new ArrayList<String>();
		
		for (FieldError fieldError : fieldErrors) {
			String msg = mensagemDeErro(fieldError.getField());
			mensagens.add(msg);
		}
		
		return ResponseEntity.badRequest().body(mensagens);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ex) {
		String msg = ex.getMessage();
		return ResponseEntity.badRequest().body(msg);
	}

	private String mensagemDeErro(String field) {
		return String.format("Erro no campo %s", field);
	}
	
}
