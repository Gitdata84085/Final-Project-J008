package com.app.dto;

import java.time.LocalDate;

import com.app.pojos.BloodType;
import com.app.pojos.Gender;
import com.app.pojos.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class PatientDTO {
	// for registering patient we have used this details.
	private int id;
	private String name;
	private LocalDate dob;
	private Gender gender;
	private BloodType type;
	private String address;
	private String state;
	private String city;
	private int pincode;
	private String mobileNo;
	private String emailid;
	private String username;
	private int user_id;
	// for adding patient
	

	

	public PatientDTO(int id2, String name2,String emailid,String mobileNo,Gender gender,LocalDate dob,String address, int id3) {
		// TODO Auto-generated constructor stub
		this.id=id2;
		this.name=name2;
		this.emailid = emailid;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.user_id=id3;
	}
	
	
	
		
}
