package com.sam.microservice.uservideoservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.microservice.uservideoservice.entity.User;
import com.sam.microservice.uservideoservice.entity.UserGroup;

@Repository
@Transactional
public class UserRepository {

	@Autowired
	private EntityManager em;
	
	public List<User> getUsers() {
		return em.createNamedQuery("getAllUsers", User.class )
				.getResultList(); 
	}
	
	public List<UserGroup> getGroups() {
		return em.createNamedQuery("getAllGroups", UserGroup.class )
				.getResultList(); 
	}
}
