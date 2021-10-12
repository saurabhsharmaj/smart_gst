package com.ebit.smartgst.model;

import javax.validation.constraints.NotBlank;

public class DeptDTO {

	Long id;
	
	@NotBlank(message = "Name cannot be blank.")
	String name;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
