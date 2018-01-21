package com.shenwl.test.springmvc.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shenwl.test.springmvc.user.dao.UserDao;
import com.shenwl.test.springmvc.user.entity.UserEntity;
@Component
public class UserDomain {

	@Autowired
	UserDao userDao;
	
	public UserEntity getUserByIdAndName(String id, String name) {
		return userDao.getUserByIdAndName(id, name);
	}
	
	public UserEntity getUserById(String id) {
		return null;
	}
	
	public Boolean login(String name, String password) {
		return true;
	}
}
