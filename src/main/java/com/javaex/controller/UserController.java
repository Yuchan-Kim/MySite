package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.javaex.dao.UserDao;
import com.javaex.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;

	@Autowired
	private UserService service;

	//[Methods]
	@RequestMapping(value ="/joinprocess", method = {RequestMethod.GET, RequestMethod.POST} )
	public String joinProcess() {

		System.out.println("MySiteUserController.joinprocess()");

		return "user/joinForm";
	}

}
