package com.fagcorps.main.Resource.Expection;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fagcorps.main.Services.Exeption.ObjextNotFoundExpction;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExpction {

	@ExceptionHandler(ObjextNotFoundExpction.class)
	public ResponseEntity<StandErrorMongo> ObjectNotFound(ObjextNotFoundExpction e , HttpServletRequest  request){
		String error = "Resource not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandErrorMongo err = new StandErrorMongo(
				Instant.now(),status.value(), e.getMessage(),error, request.getRequestURI());
	return	ResponseEntity.status(status).body(err);
		
		
		
	}
}
