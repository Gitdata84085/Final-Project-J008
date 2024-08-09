package com.app.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorDTO;
import com.app.pojos.Doctor;
import com.app.service.DoctorService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/register")
		
		public Doctor registerDoctor(@RequestBody DoctorDTO dto) {
			System.out.println(dto);
			return doctorService.register(dto);
		}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editProfile(@RequestBody DoctorDTO updatedDoctor){		
		return ResponseEntity.ok(doctorService.editProfile(updatedDoctor));
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<?> getDoctorDetails(@PathVariable int id){
		Doctor doc= doctorService.showDoctorDetails(id);
		return ResponseEntity.ok(new DoctorDTO(doc.getId(),doc.getName(),doc.getDob(),doc.getGender(),doc.getSpecialization(),doc.getJoinDate(),doc.getMobileNo(),doc.getEmailid()));
	}
	
	@GetMapping("/showall")
	public ResponseEntity<?> getAllDoctors(){
		
		return ResponseEntity.ok(doctorService.getAllDoctors().stream().map(doctor->new DoctorDTO(doctor.getId(),doctor.getName(),doctor.getMobileNo(),doctor.getGender(),doctor.getSpecialization(),doctor.getJoinDate(),doctor.getUser().getId())).collect(Collectors.toList()));
	}
	
}
