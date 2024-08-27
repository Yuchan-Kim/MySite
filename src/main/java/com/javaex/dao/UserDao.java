package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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

	public User selectUser(User user) {
		User userVo = sqlsession.selectOne("mysite.selectOne",user);

		return userVo;
	}

	public User updateUser(@Param("userNum") int userNum,
			@Param("id") String id,
			@Param("name") String name,
			@Param("pw") String pw,
			@Param("gender") String gender) {
		System.out.println("UserDao.updateUser()");
		Map<String, Object> params = new HashMap<>();
		params.put("userNum", userNum);
		params.put("id", id);
		params.put("name", name);
		params.put("pw", pw);
		params.put("gender", gender);

		sqlsession.update("mysite.updateUser", params);
		User user = new User(userNum,id,name,pw,gender);
		return user;
	}
}
