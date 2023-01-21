package com.falgun.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer RegistrationId;
	private String name;
	private String mobileNo;
	private String password;
	private String email;
	

}
