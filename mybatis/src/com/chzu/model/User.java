package com.chzu.model;

public class User {
	private Integer id;
	private String name;
	private String sex;
	private String address;

	public User() {
	}

	public User(Integer id, String name, String sex, String address) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.address = address;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString(){
		return "id="+id+"\t"+"name="+name+"\t"+"sex="+sex+"\t"+"address="+address;
	}

}
