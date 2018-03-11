package com.haven.tools.rpc.json.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String email;
	private Date birthday;
	private Object[] params;

	public User() {}

	public User(Long id, String username, String email, Date birthday) {
//		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.birthday = birthday;
	}

	public User(Long id, String username, String email, Date birthday, Object[] params) {
//		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.birthday = birthday;
		this.params = params;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", birthday=" + birthday + ", params="
				+ Arrays.toString(params) + "]";
	}

}
