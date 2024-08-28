package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	
	public void exeAddWrite(String title, String contents, int personId) {
		System.out.println("BoardService.addWrite");
		dao.addWrite(title,contents,personId);
	}
	
	public List<BoardVo> exeGetBoardList(){
		List<BoardVo> boardList = dao.getBoardList();
		
		return boardList;
	}
	
	public BoardVo exeRead(int boardId) {
		BoardVo board = dao.getBoard(boardId);
		return board;
	}
	
	public void exeDelete(int personId, int boardId) {
		dao.delete(personId, boardId);
	}
	
	public BoardVo exeModify(int boardId, int personId) {
		BoardVo board = dao.getModifyForm(boardId,personId);
		return board;
	}
}
