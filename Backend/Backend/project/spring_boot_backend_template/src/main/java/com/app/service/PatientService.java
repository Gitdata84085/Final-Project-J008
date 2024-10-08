package com.app.service;

import java.util.List;

import com.app.dto.PatientDTO;
import com.app.pojos.Patient;
import com.app.pojos.User;

public interface PatientService {
	Patient register(PatientDTO patientDto); //method definition to register patient // To add Patient to patient table and his user details to user table
	public Patient getPatientDetails(User u); // To find the patient details by user details 
	public String editProfile(PatientDTO updatedPatient);
	public Patient findPatientById(int p_id);
	public void deletePatient(int id);
	public List<Patient> getAllPatients();

}
