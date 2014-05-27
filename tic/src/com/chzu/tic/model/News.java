package com.chzu.tic.model;

import java.io.Serializable;
import java.util.Date;


public class News implements Serializable {

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content
				+ ", date=" + date + "]";
	}

	private static final long serialVersionUID = 1L;
	private Integer id;//标识属性
	private String title;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String content;//新闻内容
	private Date date;
	
	public News() {
	}

	public News(Integer id, String title,String content, Date date) {
		this.id = id;
		this.title=title;
		this.content = content;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
