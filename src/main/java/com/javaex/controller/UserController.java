package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			@RequestParam(value = "gender") String gender,@RequestParam(value = "agree", required = true) String agree) {

		System.out.println("MySiteUserController.Registration()");

		User user = new User(id,pw,name,gender);
		service.exeRegister(user);
		return "user/joinSuccess";

	}
	
	
	@RequestMapping(value ="/user/checkDuplicate", method = {RequestMethod.GET, RequestMethod.POST} )
	public String checkDuplicate(@RequestParam("id") String id, Model model) {
		boolean isDuplicate = service.isDuplicateUserId(id);

		if (!isDuplicate) {
			model.addAttribute("duplicateMessage", "이미 존재하는 아이디입니다.");
		} else {
			model.addAttribute("duplicateMessage", "사용 가능한 아이디입니다.");
		}
		model.addAttribute("id", id);
		return "user/joinForm";  // 회원가입 JSP 페이지로 다시 포워딩
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
		
		User authUser = service.exeLogin(id,pw);

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
		System.out.println(userNum);
		User user = service.exeUpdate(userNum,id,name,pw,gender);
		session.setAttribute("authUser",user);
		return "redirect:/index";
	}
	
	//아이디 중복 체크 
	@ResponseBody
	@RequestMapping(value ="/api/user/idcheck", method = {RequestMethod.GET, RequestMethod.POST} )
	public boolean idCheck(@RequestParam(value = "id") String id) {
		System.out.println("UserController.idCheck");
		System.out.println(id);
		
		boolean idCheck =service.exeIdCheck(id);
		System.out.println(idCheck);
		return idCheck;
	}




}
