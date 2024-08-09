package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.PatientDao;
import com.app.dao.UserDao;
import com.app.dto.PatientDTO;
import com.app.pojos.Patient;
import com.app.pojos.User;
import com.app.pojos.UserValidity;

@Transactional
@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private ModelMapper map;
	
	@Autowired
	private UserDao userDao;
	
	
	
	
	
	
	@Override
	public Patient getPatientDetails(User u) {
		return patientDao.findPatientByUser(u).orElse(null);	
	}

	@Override
	public String editProfile(PatientDTO updatedPatient) {
		Patient p = patientDao.findById(updatedPatient.getId()).orElse(null);
		p.setName(updatedPatient.getName());
		p.setAddress(updatedPatient.getAddress());
		p.setState(updatedPatient.getState());
		p.setCity(updatedPatient.getCity());
		p.setDob(updatedPatient.getDob());
		p.setMobileNo(updatedPatient.getMobileNo());
		p.setPincode(updatedPatient.getPincode());
		p.setEmailid(updatedPatient.getEmailid());
		patientDao.save(p);
		return "Profile edited";
	}
	
	
	// method for registering/adding patient to DB table 
	@Override
	public Patient register(PatientDTO patientDto) {
		Patient patient = map.map(patientDto, Patient.class);
		User u=userDao.findById(patientDto.getUser_id()).orElseThrow(()-> new RuntimeException("user not found!"));
		if(u!=null) {
			System.out.println(u);
			patient.setUser(u);
			
			System.out.println(patient);
		return patientDao.save(patient);
		}
		return null;
	}
	

	
	
	@Override
	public Patient findPatientById(int p_id) {
		return patientDao.findById(p_id).orElse(null);
	}

	@Override
	public void deletePatient(int id) {
		patientDao.deleteById(id);
	}
	
	@Override
	public List<Patient> getAllPatients() {
		
		return patientDao.findByUserValidity(UserValidity.ACTIVE);
	}

	

}
