package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DoctorDao;
import com.app.dao.UserDao;
import com.app.dto.DoctorDTO;
import com.app.pojos.Doctor;
import com.app.pojos.User;
import com.app.pojos.UserValidity;


@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private ModelMapper map;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Doctor register(DoctorDTO doctorDto) {
		Doctor doctor = map.map(doctorDto, Doctor.class);
		User u=userDao.findById(doctorDto.getUser_id()).orElseThrow(()-> new RuntimeException("user not found!"));
		if(u!=null) {
			System.out.println(u);
			doctor.setUser(u);
			
			System.out.println(doctor);
		return doctorDao.save(doctor);
		}
		return null;
	}
	
	@Override
	public Doctor showDoctorDetails(int id) {
		return doctorDao.findById(id).orElse(null);
	}
	
	@Override
	public List<Doctor> getAllDoctors() {
		return doctorDao.findByUserValidity(UserValidity.ACTIVE);
	}
	
	@Override
	public String editProfile(DoctorDTO d) {
		Doctor doc=doctorDao.findById(d.getId()).orElse(null);
		doc.setName(d.getName());
		doc.setDob(d.getDob());
		doc.setGender(d.getGender());
		doc.setSpecialization(d.getSpecialization());
		doc.setJoinDate(d.getJoinDate());
		doc.setMobileNo(d.getMobileNo());
		doc.setEmailid(d.getEmailid());
		//doctorDao.save(doc);
		return "profile updated" ;
	}

	
	
}
