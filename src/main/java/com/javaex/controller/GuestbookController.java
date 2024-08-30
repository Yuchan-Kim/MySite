package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.service.GuestbookService;
import com.javaex.vo.guestbookVo;
@Controller
public class GuestbookController {
	//Fields
	

	@Autowired
	private GuestbookService service;

	//Constructors

	//Getters and Setters

	//[Methods]

	@RequestMapping(value ="guestbook/addlist", method = {RequestMethod.GET, RequestMethod.POST} )
	public String list(Model model) {
		System.out.println("guestbookController.list()");

		List<guestbookVo> guestList = service.exegetPersonList();

		model.addAttribute("guestList",guestList);

		return "guestbook/addList"; 
	}

	@RequestMapping(value ="guestbook/register", method = {RequestMethod.GET, RequestMethod.POST} )
	public String register(@RequestParam(value = "name") String name, @RequestParam(value = "pw") String pw, @RequestParam(value = "comments") String comments ) {
		System.out.println("guestbookController.register()");

		guestbookVo guestVo = new guestbookVo(name,pw,comments);

		service.exeRegister(guestVo);

		return "redirect:/guestbook/addlist";

	}

	@RequestMapping(value ="guestbook/deleteformat", method = {RequestMethod.GET, RequestMethod.POST} )
	public String showDelete(Model model, @RequestParam(value = "num") int personId) {
		System.out.println("guestbookController.deleteInfo()");


		return "guestbook/deleteForm";

	}

	@RequestMapping(value ="guestbook/delete", method = {RequestMethod.GET, RequestMethod.POST} )
	public String delete(Model model, @RequestParam(value = "num") int personId, @RequestParam(value = "pw") String pw) {
		System.out.println("guestbookController.delete()");

		if(service.execheckPw(personId, pw)) {
			service.exeDeletePerson(personId);
		}


		return "redirect:/guestbook/addlist";

	}
	
	//ajaxIndex
	@RequestMapping(value = "guestbook/ajaxIndex",method = {RequestMethod.GET, RequestMethod.POST})
	public String ajaxIndex() {
		System.out.println("GuestbookController.ajaxIndex()");
		
		return "/guestbook/ajaxIndex";
		
	}











}
