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
	
	public User exeUpdate (int userNum, String id, String name, String pw, String gender) {
		System.out.println("UserService.exeUpdate()");
		User user = dao.updateUser(userNum,id,name,pw,gender);
		return user;
	}
	
	// 아이디 중복 체크 서비스 메서드
    public boolean isDuplicateUserId(String id) {
        return dao.existsById(id);
    }

}
