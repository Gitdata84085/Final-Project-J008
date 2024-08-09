package com.app.service;

import java.util.List;

import com.app.dto.DoctorDTO;
import com.app.pojos.Doctor;

public interface DoctorService {
	//register
	Doctor register(DoctorDTO doctorDto);
	
	//show by id
	public Doctor showDoctorDetails(int id);
	
	//edit
	public String editProfile(DoctorDTO d);
	
	//show all
	public List<Doctor> getAllDoctors();
	
	//public Doctor findDoctorById(int id);
	//public List<Doctor> getDoctorByDept(int id);
	//public void sendMailToPatient(Appointment a);
	//public Doctor getDoctorDetails(User u);
}
