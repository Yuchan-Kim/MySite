package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.User;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlsession;
	
	public int registeration(User user) {
		System.out.println("Registration Process()");
		int count = sqlsession.insert("mysite.insert", user);
		return count;
	}
}
