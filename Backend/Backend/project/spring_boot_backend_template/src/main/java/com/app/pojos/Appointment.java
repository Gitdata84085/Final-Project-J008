package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
    private Patient patient;
    
    private int consultationFee;
    
    @Column(length = 30)
    private String specialization;
    
    private LocalDateTime appoint;
    
    @Enumerated(EnumType.ORDINAL)
    private Appstatus status;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

}
