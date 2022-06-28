package com.restservice.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restservice.Exceptions.CustomGenericException;


@RestControllerAdvice
public class ExceptionAspect {

	@ExceptionHandler(CustomGenericException.class)
	public ResponseEntity<String> customException(CustomGenericException exception) {
		System.err.println("error code : "+ exception.getErrCode());
		System.err.println("error message : "+exception.getErrMsg());
		return new ResponseEntity<>(exception.getErrMsg(), HttpStatus.BAD_REQUEST);
	}

}
