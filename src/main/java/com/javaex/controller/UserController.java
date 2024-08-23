package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.UserDao;
import com.javaex.service.UserService;
import com.javaex.vo.User;

import jakarta.servlet.http.HttpSession;

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
	
	@RequestMapping(value ="/registration", method = {RequestMethod.GET, RequestMethod.POST} )
	public String registration(@RequestParam(value = "id") String id, 
							   @RequestParam(value = "pw") String pw,
							   @RequestParam(value = "name") String name,
							   @RequestParam(value = "gender") String gender) {
		
		System.out.println("MySiteUserController.Registration()");
		User user = new User(id,pw,name,gender);
		
		
		int count = service.exeRegister(user);
		System.out.println(count + "건 등록되었습니다.");
		
		return "user/joinSuccess";
	}
	
	@RequestMapping(value ="/loginform", method = {RequestMethod.GET, RequestMethod.POST} )
	public String loginform() {
		
		System.out.println("MySiteUserController.loginform()");
		
		
		return "user/loginForm";
	}
	
	@RequestMapping(value ="/user/login", method = {RequestMethod.GET, RequestMethod.POST} )
	public String login(@ModelAttribute User user, HttpSession session) {
		System.out.println("MySiteUserController.login()");
		User authUser = service.exeLogin(user);
		
		session.setAttribute("",authUser);
		
		return "";
	}
	
	

}
