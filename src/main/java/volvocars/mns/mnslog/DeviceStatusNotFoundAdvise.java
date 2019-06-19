package volvocars.mns.mnslog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DeviceStatusNotFoundAdvise {
	
	@ResponseBody
	@ExceptionHandler(DeviceStatusNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String deviceStatusNotFoundHandler(DeviceStatusNotFoundException ex) {
		return ex.getMessage();
	}

}
