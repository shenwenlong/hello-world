package com.shenwl.test.springmvc.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shenwl.test.springmvc.dao.TeacherDAO;
import com.shenwl.test.springmvc.entity.TeacherEntity;
@Component
public class TeacherDomain {
	
	@Autowired
	TeacherDAO teacherDao;
	
	public TeacherEntity getTeacher(String id) {
		return teacherDao.getTeacherById(Integer.valueOf(id));
	}
}
