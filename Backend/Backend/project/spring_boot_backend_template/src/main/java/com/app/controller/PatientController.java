package com.app.controller;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.app.dto.PatientDTO;
import com.app.pojos.Patient;
import com.app.pojos.Role;
import com.app.pojos.UserValidity;

import com.app.service.PatientService;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	
	//for registering patient 
	@PostMapping("/register")
	public Patient registerPatient(@RequestBody PatientDTO dto) {
		System.out.println(dto);
		return patientService.register(dto);
	}
	
	
	@PutMapping("/edit")
	public ResponseEntity<?> editProfile(@RequestBody PatientDTO updatedPatient){
		return ResponseEntity.ok(patientService.editProfile(updatedPatient));
	}
	
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deletePatient(@RequestParam int id){
		return ResponseEntity.ok("Patient Deleted");
		
	}
	@GetMapping("/allpatients")
	public ResponseEntity<?> findAllPatient(){
		return ResponseEntity.ok(patientService.getAllPatients().stream().map(patient->new PatientDTO(patient.getId(),patient.getName(),patient.getEmailid(),patient.getMobileNo(),patient.getGender(),patient.getDob(),patient.getAddress(),patient.getUser().getId())).collect(Collectors.toList()));
	}
	
	
}
