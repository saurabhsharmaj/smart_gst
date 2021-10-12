package com.ebit.smartgst.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrorDTO {

	private HttpStatus status;
	private List<String> message;

	public ApiErrorDTO() {
		super();
	}
	
	public ApiErrorDTO(HttpStatus status, List<String> message) {
		super();
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

}
