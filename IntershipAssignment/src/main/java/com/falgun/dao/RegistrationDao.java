package com.falgun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falgun.model.Registration;
@Repository
public interface RegistrationDao extends JpaRepository<Registration, Integer>{

	public Registration findByMobileNo(String mobileNo);

}
