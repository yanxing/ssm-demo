package com.chzu.tic.model;

import java.io.Serializable;

public class File implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;//文件名
	private String path;//文件路径

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File() {
	}

	public File(Integer id, String name, String path) {
		this.id = id;
		this.name = name;
		this.path = path;
	}
	

}
