package com.chzu.model;

import java.io.Serializable;

public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// ��ʶ����
	private String username;// �û���
	private String password;// ����

	public Admin() {
	}

	public Admin(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}