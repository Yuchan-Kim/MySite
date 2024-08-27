package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.UserDao;
@Controller
public class BoardController {
	
	@Autowired
	private UserDao dao;
	@RequestMapping(value ="/board/list", method = {RequestMethod.GET, RequestMethod.POST} )
	public String list() {
		
		return "board/list";
		
	}
	@RequestMapping(value ="/board/modifyform", method = {RequestMethod.GET, RequestMethod.POST} )
	public String modifyform() {
		
		return "board/modiftForm";
		
	}
	@RequestMapping(value ="/board/read", method = {RequestMethod.GET, RequestMethod.POST} )
	public String read() {
		
		return "board/read";
	}
	@RequestMapping(value ="/board/writeform", method = {RequestMethod.GET, RequestMethod.POST} )
	public String writeform() {
		
		return "board/writeForm";
	}
}
