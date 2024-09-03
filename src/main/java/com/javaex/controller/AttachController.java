package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.AttachService;

@Controller
public class AttachController {
	
	@Autowired
	AttachService service;
	
	@RequestMapping(value = "/attach/form",method = {RequestMethod.GET, RequestMethod.POST})
	public String form() {
		System.out.println("AttachController.form()");
		return "/attach/form";
	}
	
	@RequestMapping(value = "/attach/upload",method = {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam(value ="file") MultipartFile file, Model model) {//파일을 담는 변수  
		System.out.println("AttachController.upload()");
		System.out.println(file.getOriginalFilename());
		
		String saveName = service.exeUpload(file);
		model.addAttribute("saveName",saveName);
		
		return "attach/result";
	}
}
