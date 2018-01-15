package com.shenwl.test.springmvc.dao;

import org.springframework.stereotype.Component;

import com.shenwl.test.springmvc.entity.TeacherEntity;
@Component
public interface TeacherDAO {

	public TeacherEntity getTeacherById(Integer id);
}
