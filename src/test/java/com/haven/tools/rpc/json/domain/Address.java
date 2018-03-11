package com.haven.tools.rpc.json.domain;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String description;
	
	public Address() {}

	public Address(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", description=" + description + "]";
	}
	
}
