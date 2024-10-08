package com.app.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="bill")
public class Bill {
	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@JoinTable(
	        name = "Bill_Service",
	        joinColumns = {
	            @JoinColumn(name = "b_id")
	        },
	        inverseJoinColumns = {
	            @JoinColumn(name = "s_id")
	        }
	    )
	@ManyToMany
	private Set<Service> service = new HashSet<Service>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "p_id")
	private Patient patient;
	
	private LocalDate billDate;
	
	private int total;
	
	private String status;

	public Bill() {
		// TODO Auto-generated constructor stub
	}

}
