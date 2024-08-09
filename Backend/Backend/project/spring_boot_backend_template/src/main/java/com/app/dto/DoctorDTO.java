package com.app.dto;

import java.time.LocalDate;

import com.app.pojos.Department;
import com.app.pojos.Gender;
import com.app.pojos.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class DoctorDTO {
	private int id;
	private String name;
	private LocalDate dob;
	private Gender gender;
	private String specialization;
	private LocalDate joinDate;
	private String mobileNo;
	private String emailid;
	private String username;
	private int user_id;
	private Role role;
	private Department dept;
	
	

	public DoctorDTO(int id, String name, LocalDate dob, Gender gender, String specialization, LocalDate joinDate,
			String mobileNo, String emailid) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.specialization = specialization;
		this.joinDate = joinDate;
		this.mobileNo = mobileNo;
		this.emailid = emailid;
		
	}
	public DoctorDTO(int id,String name,String mobileNo, Gender gender, String specialization, LocalDate joinDate,int user_id) {
		this.id=id;
		this.name=name;
		this.mobileNo=mobileNo;
		this.gender = gender;
		this.specialization =specialization;
		this.joinDate = joinDate;
		this.user_id=user_id;
	}
	
	public DoctorDTO(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public DoctorDTO(int id,String name,int user_id) {
		this.id=id;
		this.name=name;
		this.user_id=user_id;
	}
	
	

	
	
	
	
	
}
