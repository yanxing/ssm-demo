package com.chzu.tic.model;

import java.io.Serializable;

public class Online implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;//±Í ∂ Ù–‘

	public Online() {
	}

	public Online(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
