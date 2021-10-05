package com.ebit.smartgst.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.ebit.smartgst.model.Role;

public class Employeevo {
	
	private Long id;

	private String username;
	private String password;
	private boolean enabled;

	private Set<Role> roles = new HashSet<>();

	private Integer deptId;


}
