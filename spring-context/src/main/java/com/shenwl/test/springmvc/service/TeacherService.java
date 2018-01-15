package com.shenwl.test.springmvc.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shenwl.test.springmvc.domain.TeacherDomain;
import com.shenwl.test.springmvc.entity.TeacherEntity;

@Controller
public class TeacherService {

	Log log = LogFactory.getLog(TeacherService.class);
	@Autowired
	TeacherDomain teacherDomain;
	
	@RequestMapping(value="/teacher/getTeahcer", method=RequestMethod.GET)
	public void getTeacherService(@RequestParam(value="id") String id) {
		try {
			log.debug(this.getClass().getSimpleName()
					+"[getTeacherService()]");
			TeacherEntity te = teacherDomain.getTeacher(id);
			log.debug("teacher name:["+te.getName()+"]");
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
