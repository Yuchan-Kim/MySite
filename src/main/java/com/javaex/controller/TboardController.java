package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.TboardService;
import com.javaex.vo.TboardVo;

@Controller
public class TboardController {
	
	@Autowired
	private TboardService service;
	
	//List
	@RequestMapping(value = "/tboard/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("TboardController.list()");
		
		List<TboardVo> tboardList = service.exeList();
		model.addAttribute("tboardList",tboardList);
		
		return "tboard/list";
	}
	
	//Paging
	@RequestMapping(value = "/tboard/list2", method = {RequestMethod.GET, RequestMethod.POST})
	public String list2(Model model, @RequestParam(value = "crtpage", required = false/*값이 없어도 상관없음을 나타낸다. True 일때나 , required가 없으면 무조건 parameter가 있어여한다.  */, defaultValue = "1") int crtPage) {
		System.out.println("TboardController.list()");
		
		Map<String,Object> pMap = service.exeList2(crtPage);
		System.out.println(pMap);
		model.addAttribute("pMap",pMap);
		
		return "tboard/list2";
	}
	
	//Search + paging
	@RequestMapping(value = "/tboard/list3", method = {RequestMethod.GET, RequestMethod.POST})
	public String list3(Model model,@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword, 
						@RequestParam(value = "crtpage", required = false/*값이 없어도 상관없음을 나타낸다. True 일때나 , required가 없으면 무조건 parameter가 있어여한다.  */, 
						defaultValue = "1") int crtPage) {
		System.out.println("TboardController.list()");
		
		Map<String,Object> pMap = service.exeList3(crtPage, keyword);
		System.out.println(pMap);
		System.out.println(keyword);
		model.addAttribute("pMap",pMap);
		
		return "tboard/list3";
	}
}
