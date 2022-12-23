package com.vti.dto.creating;

import com.vti.entity.Group;

public class ProductFormForCreating {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group toEntity() {
		return new Group(name);
	}

}
