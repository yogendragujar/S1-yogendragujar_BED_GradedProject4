package com.greatlearning.employee.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@RestControllerAdvice
@Component
public class EmpExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public Error invalidEmployeeId(IllegalArgumentException exception) {
		Error error = Error.builder().code(100).message(exception.getMessage()).build();
		return error;
	}
}

@Builder
@AllArgsConstructor
@Getter
class Error {
	private int code;
	private String message;
}