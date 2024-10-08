package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="Prescription")
@ToString
public class Prescription {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="doctor_id",nullable = false)
	private Doctor doc;
	
	@ManyToOne
	@JoinColumn(name="patient_id",nullable = false)
	private Patient patient; 
	
	private LocalDate date;
	
	@OneToMany(mappedBy ="prescriptionid", cascade =  CascadeType.ALL, orphanRemoval = true)
	private List<PrescriptionDetails> prescriptiondetails=new ArrayList<>();
	public Prescription() {
		// TODO Auto-generated constructor stub
	}

}
