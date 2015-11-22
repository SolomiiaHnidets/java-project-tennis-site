package com.tennis.exceptions;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<String> handleBasicException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), getHeaders(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), getHeaders(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<String> handleEntityExistsException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), getHeaders(),
				HttpStatus.FORBIDDEN);
	}

	public HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();

		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);

		return headers;
	}

}
