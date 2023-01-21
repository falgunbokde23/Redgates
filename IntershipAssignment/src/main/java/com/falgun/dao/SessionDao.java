package com.falgun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falgun.model.CurrentUserSession;

public interface SessionDao extends JpaRepository<CurrentUserSession, Integer> {

	
	public  CurrentUserSession  findByUuid(String uuid);
}
