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
		int count = sqlsession.insert("user.insert", user);
		return count;
	}

	public User selectUser(String id, String pw) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("pw", pw);
		User user = (User)sqlsession.selectOne("user.selectOne",params);
		

		return user;
	}

	public User updateUser(int userNum,
			 String id,
			 String name,
			 String pw,
			 String gender) {
		Map<String, Object> params = new HashMap<>();
		params.put("userNum", userNum);
		params.put("id", id);
		params.put("name", name);
		params.put("pw", pw);
		params.put("gender", gender);

		sqlsession.update("user.updateUser", params);
		User user = new User(userNum,id,name,pw,gender);
		return user;
	}
	
	// 아이디 중복 여부 확인
    public boolean existsById(String id) {
        Integer count = sqlsession.selectOne("user.existsById", id);
        if (count >0) {
        	return false;
        }else {
        	return true;
        }
        
    }
    
    //아이디 중복 체크 2
    public int selectUserById(String id) {
    	System.out.println("UserDao.selectUserById()");
    	System.out.println(id);
    	
    	int count = sqlsession.selectOne("user.selectById",id);
    	System.out.println(count);
    	return count;
    	
    }
}
