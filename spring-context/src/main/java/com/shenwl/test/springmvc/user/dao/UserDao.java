package com.shenwl.test.springmvc.user.dao;

import org.springframework.stereotype.Component;

import com.shenwl.test.springmvc.user.entity.UserEntity;

@Component
public interface UserDao {
	public UserEntity getUserByIdAndName(String id, String name);
}
