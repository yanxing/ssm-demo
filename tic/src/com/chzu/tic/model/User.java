package com.chzu.tic.model;

import java.io.Serializable;

public class User implements Serializable {
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", typename=" + typename
				+ ", email=" + email + "]";
	}

	private static final long serialVersionUID = 1L;
	private Integer id;// 标识属性
	private String username;// 用户名
	private String password;// 密码
	private Integer type;// 用户类型
	private String team;//队友
	private String email;// 邮箱
	private String typename;
	private String state;//参赛状态
	private Project project;
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	private String repassword;//密码确定 ，hj修改
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public User() {
	}

	public User(Integer id, String username, String password, Integer type,String team,
			String email,String typename,String state,Project project) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.type = type;
		this.team=team;
		this.email = email;
		this.typename=typename;
		this.state=state;
		this.project=project;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	// 重写equals()方法，name,pass相同即为同一用户
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == User.class) {
			User user = (User) obj;
			return this.getUsername().equals(user.getUsername())
					&& this.getPassword().equals(user.getPassword());
		}
		return false;
	}

}
