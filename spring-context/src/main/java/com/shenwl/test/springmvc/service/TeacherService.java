package com.shenwl.test.springmvc.service;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shenwl.test.springmvc.domain.TeacherDomain;
import com.shenwl.test.springmvc.entity.TeacherEntity;

@RestController
public class TeacherService {

	Log log = LogFactory.getLog(TeacherService.class);
	@Autowired
	TeacherDomain teacherDomain;
	
	@RequestMapping(value="rest/teacher/getTeahcer", method=RequestMethod.POST)
	@ResponseBody
	public TeacherEntity getTeacherService(@RequestBody TeacherEntity request) throws Exception {
		TeacherEntity te = null;
		log.debug("param["+request.getId()+"]");
		try {
			log.debug(this.getClass().getSimpleName()
					+"[getTeacherService()]");
			String id = request.getId().toString();
			te = teacherDomain.getTeacher(id);
			log.debug("teacher name:["+te.getName()+"]");
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return te;
	}
}
