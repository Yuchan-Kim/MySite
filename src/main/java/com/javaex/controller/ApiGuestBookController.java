package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.guestbookVo;

@Controller
public class ApiGuestBookController {
	
	@Autowired
	private GuestbookService service;
	
	@ResponseBody
	@RequestMapping(value ="/api/guestbook/list") 
	public List<guestbookVo> list() {
		System.out.println("API GuestbookController.list()");
		List<guestbookVo> guestbookList = service.exegetPersonList();
		System.out.println(guestbookList);
		
		return guestbookList;
	}
	
}
