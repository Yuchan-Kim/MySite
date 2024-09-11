package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.TboardVo;

@Repository
public class TboardDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<TboardVo> selectList() {
		System.out.println("TboardDao.selectList()");
		List<TboardVo> tboardList = sqlsession.selectList("tboard.selectList");
		
		return tboardList;
		
	}
	
	public List<TboardVo> selectList2(Map<String,Integer> limitMap) {
		System.out.println("TboardDao.selectList()");
		List<TboardVo> tboardList = sqlsession.selectList("tboard.selectList2",limitMap);
		
		return tboardList;
		
	}
	
	public List<TboardVo> selectList3(Map<String,Object> limitMap) {
		System.out.println("TboardDao.selectList()");
		List<TboardVo> tboardList = sqlsession.selectList("tboard.selectList3",limitMap);
		
		return tboardList;
		
	}
	
	public int selectTotalCount() {
		System.out.println("TboardDao.selectCount()");
		int count = sqlsession.selectOne("selecttotalCnt");
		System.out.println("Total count: " + count);
		return count;
	}
}
