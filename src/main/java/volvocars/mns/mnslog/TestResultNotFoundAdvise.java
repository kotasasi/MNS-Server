package volvocars.mns.mnslog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TestResultNotFoundAdvise {
	
	@ResponseBody
	@ExceptionHandler(TestResultNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String testResultNotFoundHandler(TestResultNotFoundException ex) {
		return ex.getMessage();
	}

}
