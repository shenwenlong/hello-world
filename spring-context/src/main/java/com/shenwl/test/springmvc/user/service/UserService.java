package com.shenwl.test.springmvc.user.service;


import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.google.gson.Gson;
import com.shenwl.test.springmvc.common.ResponseMessage;
import com.shenwl.test.springmvc.user.domain.UserDomain;
import com.shenwl.test.springmvc.user.entity.UserEntity;



@RestController
@RequestMapping(value="/user")
public class UserService {

	Log log = LogFactory.getLog(UserService.class);
	@Autowired
	UserDomain userDomain;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam(value="username") String userName,
			@RequestParam(value="password") String password) {
		// set response message
		ResponseMessage rm = new ResponseMessage();
		// create gson instance
		Gson gson = new Gson();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		rm.setDate(sdfDate.format(new Date(System.currentTimeMillis())));
		SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
		rm.setTime(sdfTime.format(new Date(System.currentTimeMillis())));
		log.debug("username:["+userName+"]");
		log.debug("password:["+password+"]");
		if (userDomain.login(userName, password)) {
			// login failed			
			rm.setFlag(false);
			rm.setMessage("userName or password is wrong");
			
			return gson.toJson(rm);
		}
		// login success
		rm.setFlag(true);
		rm.setMessage("success");
		return gson.toJson(rm);
	}
	@RequestMapping(value="/rest/addUser")
	@ResponseBody
	public String addUser(@RequestBody UserEntity userEntity) {
		log.debug(userEntity.getName());
		ResponseMessage rm = new ResponseMessage();
		// create gson instance
		Gson gson = new Gson();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		rm.setDate(sdfDate.format(new Date(System.currentTimeMillis())));
		SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
		rm.setTime(sdfTime.format(new Date(System.currentTimeMillis())));
		if(1 == userDomain.addUser(userEntity)) {
			rm.setFlag(true);
			rm.setMessage("success");
		}else {
			rm.setFlag(false);
			rm.setMessage("add user failed.");
		}
		return gson.toJson(rm);
	}
}
