package com.ebit.smartgst.model;

import javax.validation.constraints.NotNull;

public class DeptDTO {

	Long id;
	
	@NotNull(message = "Name cannot blank.")
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
