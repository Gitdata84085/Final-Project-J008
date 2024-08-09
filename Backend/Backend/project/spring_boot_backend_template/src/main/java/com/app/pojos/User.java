package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user")
public class User {
	public User()
	{
		
	}
	public User(String username, String password, Role userRole) {
		super();
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=20,nullable=false)
	private String username;
	@Column(length=20,nullable=false)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role userRole;
	private UserValidity validity;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userRole=" + userRole + "]";
	}
	

}
