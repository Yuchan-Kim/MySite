package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	//Register
	public int exeRegister(User user) {
		int count = dao.registeration(user);
		return count;
	}
	
	//Login
	public User exeLogin(User user) {
		System.out.println("UserService.exeLogin()");
		User userVo = dao.selectUser(user);
		return userVo;
	}

}
