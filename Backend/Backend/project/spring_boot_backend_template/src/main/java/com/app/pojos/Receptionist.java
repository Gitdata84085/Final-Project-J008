package com.app.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Receptionist {

	private String name;
	private Role role;
	public Receptionist() {
		
	}
	public Receptionist(String name, Role role) {
		super();
		this.name = name;
		this.role = role;
	}
	

}
