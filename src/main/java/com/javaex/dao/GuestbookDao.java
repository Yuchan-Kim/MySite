package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.guestbookVo;
@Repository
public class GuestbookDao {
	@Autowired
	private SqlSession sqlsession;



	public void registerInfo(guestbookVo guest) {
		sqlsession.insert("guestbook.insert", guest);
	}

	public int deletePerson(int no){
		int count = sqlsession.delete("guestbook.delete",no);


		return count;
	}

	public guestbookVo getPersonInfo(int no) {
		guestbookVo guest1 = sqlsession.selectOne("guestbook.selectOne");

		return guest1;

	}

	public List<guestbookVo> getPersonList() {
		List<guestbookVo> guestList = sqlsession.selectList("guestbook.selectList");

		return guestList;
	}

	public boolean checkPw(int no,String pw) {
		guestbookVo guest = sqlsession.selectOne("guestbook.selectOne",no);


		if(guest.getPassword().equals(pw)) {
			return true;
		}else {
			return false;
		}
	}




}
