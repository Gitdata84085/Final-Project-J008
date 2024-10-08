package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="prescription_dtls")
@ToString
public class PrescriptionDetails {


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(length = 40)
	private String dosage;
	@Column(length=40)
	private String duration;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="prescription_id",nullable = false)
	private Prescription prescriptionid;
	@ManyToOne
	@JoinColumn(name="medicine_id",nullable = false)
	private Medicine medicineid;

	public PrescriptionDetails() {
		
	}
	
	public PrescriptionDetails(String dosage, String duration, int quantity, Prescription prescriptionid,
			Medicine medicineid) {
		super();
		this.dosage = dosage;
		this.duration = duration;
		this.quantity = quantity;
		this.prescriptionid = prescriptionid;
		this.medicineid = medicineid;
	}

}
