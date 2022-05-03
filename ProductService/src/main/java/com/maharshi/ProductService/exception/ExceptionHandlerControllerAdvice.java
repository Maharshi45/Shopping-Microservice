package com.maharshi.ProductService.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ExceptionResponse handleResourceNotFoundException(ProductNotFoundException re, HttpServletRequest request) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(re.getMessage());
		response.setRequestUri(request.getRequestURI());

		return response;

	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ExceptionResponse handleException(Exception e, HttpServletRequest request) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setRequestUri(request.getRequestURI());

		return response;

	}

}
