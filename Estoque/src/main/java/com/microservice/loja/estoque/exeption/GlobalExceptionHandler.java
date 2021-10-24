package com.microservice.loja.estoque.exeption;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { HttpClientErrorException.class})
	protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "O PRODUTO INFORMADO NÃO FOI ENCONTRADO" + request.getContextPath();
		
		logger.error("valor informado {} invalido" + request.getParameterMap());
		
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(value = {NoSuchElementException.class}) 
	protected ResponseEntity<Object> handleNumeroPageNoInvalido (RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "O PARAMETRO NÃO É VALIDO";
		
		logger.error("valor informado {} invalido");
		
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}