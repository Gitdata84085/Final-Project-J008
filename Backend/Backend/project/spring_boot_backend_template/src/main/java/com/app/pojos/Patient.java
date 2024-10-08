package com.app.pojos;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 30,nullable = false)
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate dob;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	@Enumerated(EnumType.ORDINAL)
	private BloodType type;
	@Column(length = 100)
	private String address;
	@Column(length = 20)
	private String state;
	@Column(length = 20)
	private String city;
	private int pincode;
	@Column(length = 15)
	private String mobileNo;
	@Column(length = 30,nullable = false)
	private String emailid;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private User user;
	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Prescription> prescription=new ArrayList<>();
	
	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Bill> bills=new ArrayList<Bill>();
	
	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
	private List<Appointment> appointments = new ArrayList<Appointment>();


	public Patient() {
		
	}
	

	public Patient(String name, LocalDate dob, Gender gender, BloodType type, String address, String state, String city,
			int pincode, String mobileNo, String emailid) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.type = type;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.emailid = emailid;
	}
	

	@Override
	public String toString() {
		return "Patient [name=" + name + ", dob=" + dob + ", gender=" + gender + ", type=" + type + ", address="
				+ address + ", state=" + state + ", city=" + city + ", pincode=" + pincode + ", mobileNo=" + mobileNo
				+ ", emailid=" + emailid + "]";
	}

}
