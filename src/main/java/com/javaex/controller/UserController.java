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
	@RequestMapping(value ="/user/joinprocess", method = {RequestMethod.GET, RequestMethod.POST} )
	public String joinProcess() {

		System.out.println("MySiteUserController.joinprocess()");

		return "user/joinForm";
	}
	
	@RequestMapping(value ="/user/registration", method = {RequestMethod.GET, RequestMethod.POST} )
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
	
	@RequestMapping(value ="/user/loginform", method = {RequestMethod.GET, RequestMethod.POST} )
	public String loginform() {
		
		System.out.println("MySiteUserController.loginform()");
		
		
		return "user/loginForm";
	}
	
	@RequestMapping(value ="/user/login", method = {RequestMethod.GET, RequestMethod.POST} )
	public String login(@RequestParam(value = "loginId") String id, 
			   @RequestParam(value = "loginPW") String pw, HttpSession session) {
		System.out.println("MySiteUserController.login()");
		User user = new User(id,pw);
		User authUser = service.exeLogin(user);
		
		session.setAttribute("authUser",authUser);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value ="/user/logout", method = {RequestMethod.GET, RequestMethod.POST} )
	public String logout(HttpSession session) {
		System.out.println("MySiteUserController.login()");
		session.removeAttribute("authUser");
		
		return "redirect:/index";
	}
	

	
	@RequestMapping(value ="/user/edituser", method = {RequestMethod.GET, RequestMethod.POST} )
	public String edit(HttpSession session) {
		System.out.println("MySiteUserController.editform()");
		
		return "user/editForm";
	}
	
	@RequestMapping(value ="/user/update", method = {RequestMethod.GET, RequestMethod.POST} )
	public String update(@RequestParam(value = "id") String id, 
			   			 @RequestParam(value = "pw") String pw,
			   			 @RequestParam(value = "name") String name,
			   			 @RequestParam(value = "gender") String gender,
			   			 HttpSession session) {
		System.out.println("MySiteUserController.editform()");
		User authUser = (User) session.getAttribute("authUser");
		int userNum = authUser.getUserNum();
		User user = service.exeUpdate(userNum,id,name,pw,gender);
		session.setAttribute("authUser",user);
		return "redirect:/index";
	}
	
	

}
