package com.app.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
	private String name;
	private Role role;
	
	public Admin()
	{
		
	}

	public Admin(String name, Role role) {
		super();
		this.name = name;
		this.role = role;
	}
	
}
