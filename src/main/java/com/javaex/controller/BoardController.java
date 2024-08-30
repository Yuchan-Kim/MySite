package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.UserDao;
import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.User;

import jakarta.servlet.http.HttpSession;
@Controller
public class BoardController {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value ="/board/list", method = {RequestMethod.GET, RequestMethod.POST} )
	public String list(Model model) {
		List<BoardVo> boardList = service.exeGetBoardList();
		model.addAttribute("boardList",boardList);

		return "board/list";
		
	}
	@RequestMapping(value ="/board/modifyform", method = {RequestMethod.GET, RequestMethod.POST} )
	public String modifyform(HttpSession session,@RequestParam(value = "id") int boardId , Model model) {
		User user = (User) session.getAttribute("authUser");
		if (user == null) {
	        return "redirect:/user/loginform";
	    }else {
	    	BoardVo board = service.exeModify(boardId, user.getUserNum());
	    	if(board == null) {
	    		return "redirect:/board/list";
	    	}else {
	    		model.addAttribute("board",board);
	    		return "board/modifyForm";
	    	}
	    	
	    }
		
		
	}
	
	@RequestMapping(value ="/board/modify", method = {RequestMethod.GET, RequestMethod.POST} )
	public String modify(HttpSession session,@RequestParam(value = "title") String title,@RequestParam(value = "contents") String contents,
			@RequestParam(value = "boardId")int boardId) {
		User user = (User) session.getAttribute("authUser");
		if (user == null) {
	        return "redirect:/user/loginform";
	    }else {
	    	service.exeChange(boardId, title, contents);
	    	
	    }
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value ="/board/read", method = {RequestMethod.GET, RequestMethod.POST} )
	public String read(@RequestParam(value = "boardId") int boardId, Model model) {
		BoardVo board = service.exeRead(boardId);
		model.addAttribute("board", board);
		return "board/read";
	}
	
	@RequestMapping(value ="/board/delete", method = {RequestMethod.GET, RequestMethod.POST} )
	public String delete(HttpSession session,@RequestParam(value = "title") int boardId) {
		 User user = (User) session.getAttribute("authUser");
		// 사용자 정보가 없으면 /index로 리다이렉트
	    if (user == null) {
	        return "redirect:/user/loginform";
	    }else {
	    	service.exeDelete(user.getUserNum(),boardId);
	    }
	    
	    
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/writeform", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeform(HttpSession session) {
	    // 세션에서 사용자 정보 확인
	    User user = (User) session.getAttribute("authUser");

	    // 사용자 정보가 없으면 /index로 리다이렉트
	    if (user == null) {
	        return "redirect:/user/loginform";
	    }

	    // 사용자 정보가 있으면 writeForm 페이지로 이동
	    return "board/writeForm";
	}

	@RequestMapping(value = "/board/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam(value = "title") String title,
	                    @RequestParam(value = "contents") String contents,
	                    HttpSession session) {

	    User user = (User) session.getAttribute("authUser");

	    // 세션에 사용자 정보가 없으면 /index로 리다이렉트
	    if (user == null) {
	        return "redirect:/index";
	    }

	    // 사용자 정보가 있는 경우 게시글 작성 처리
	    int personId = user.getUserNum();
	    service.exeAddWrite(title, contents, personId);

	    return "redirect:/board/list";
	}

}
