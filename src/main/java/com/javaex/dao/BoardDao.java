package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public void addWrite(String title,String contents,int personId) {
		System.out.println("BoardDao.addWrite");
		Map<String,Object> params = new HashMap<>();
		params.put("title",title);
		params.put("contents", contents);
		params.put("personId", personId);
		sqlsession.insert("boards.insert",params);
	}
	
	public List<BoardVo> getBoardList(){
		List<BoardVo> boardList = sqlsession.selectList("boards.selectList");
		return boardList;
	}
	
	public BoardVo getBoard(int boardId) {
		BoardVo board = sqlsession.selectOne("boards.selectOne",boardId);
		sqlsession.update("boards.viewUpdate",boardId);
		return board;
	}
	
	public void delete(int personId,int boardId) {
		Map<String,Object> params = new HashMap<>();
		params.put("personId", personId);
		params.put("boardId", boardId);
		sqlsession.delete("boards.delete",params);
	}
	
	public BoardVo getModifyForm(int boardId, int personId) {
		Map<String,Object> params = new HashMap<>();
		params.put("personId", personId);
		params.put("boardId", boardId);
		BoardVo board = sqlsession.selectOne("boards.selectOne",params);
		return board;
	}
}
