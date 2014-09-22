package com.chzu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 标识属性
	private String name;// 院系名称
	private Set<Professional> professionals = new HashSet<Professional>();

	public Department() {
	}

	public Department(Integer id, String name, Set<Professional> professionals) {
		this.id = id;
		this.name = name;
		this.professionals = professionals;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Professional> getProfessionals() {
		return professionals;
	}

	public void setProfessionals(Set<Professional> professionals) {
		this.professionals = professionals;
	}

}