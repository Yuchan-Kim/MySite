package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.TboardDao;
import com.javaex.vo.TboardVo;

@Service
public class TboardService {
	
	@Autowired
	private TboardDao dao;
	
	public List<TboardVo> exeList() {
		System.out.println("TboardService.exeList()");
		List<TboardVo> tboardList = dao.selectList();
		return tboardList;
		
	}
	
	public Map<String, Object> exeList2(int crtPage) {
		System.out.println("TboardService.exeList()");
		
		
		
		//List
		int listCnt = 10;
		
		crtPage = ((crtPage > 0) ? crtPage : (crtPage = 1));
		
	
		int startRowNum = (crtPage - 1) * listCnt;
		Map<String, Integer> limitMap = new HashMap<String,Integer>();
		limitMap.put("listCnt", listCnt);
		limitMap.put("startRowNum", startRowNum);
		List<TboardVo> tboardList = dao.selectList2(limitMap);
		
		
		//Page Numbers
		
		//Number of buttons showing on the bottom
		//Limit of page number appears on the bottom
		int pageBtnCount = 5;
		int totalCnt = dao.selectTotalCount(); //db에서 정보 추출 예정
		
		//Last page number
		int endPageBtnNo = (int) Math.ceil(crtPage/ (double)pageBtnCount) * pageBtnCount;
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;
		
		// Next / prev arrow 
		boolean next = false;
		
		if(listCnt * endPageBtnNo < totalCnt) {
			next = true;
		}else {
			endPageBtnNo=(int) Math.ceil(totalCnt/(double)listCnt);
		}
		
		boolean prev = false;
		
		if (startPageBtnNo != 1) {
			prev = true;
		}
		
		Map<String, Object> pMap = new HashMap<String,Object>();
		pMap.put("next", next);
		pMap.put("prev", prev);
		pMap.put("tboardList", tboardList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		
		
		
		return pMap;
		
	}
	
	public Map<String, Object> exeList3(int crtPage, String keyword) {
		System.out.println("TboardService.exeList()");
		
		
		
		//List
		int listCnt = 10;
		
		crtPage = ((crtPage > 0) ? crtPage : (crtPage = 1));
		
	
		int startRowNum = (crtPage - 1) * listCnt;
		Map<String, Object> limitMap = new HashMap<String,Object>();
		limitMap.put("listCnt", listCnt);
		limitMap.put("startRowNum", startRowNum);
		limitMap.put("keyword", keyword);
		List<TboardVo> tboardList = dao.selectList3(limitMap);
		
		
		//Page Numbers
		
		//Number of buttons showing on the bottom
		//Limit of page number appears on the bottom
		int pageBtnCount = 5;
		int totalCnt = dao.selectTotalCount(); //db에서 정보 추출 예정
		
		//Last page number
		int endPageBtnNo = (int) Math.ceil(crtPage/ (double)pageBtnCount) * pageBtnCount;
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;
		
		// Next / prev arrow 
		boolean next = false;
		
		if(listCnt * endPageBtnNo < totalCnt) {
			next = true;
		}else {
			endPageBtnNo=(int) Math.ceil(totalCnt/(double)listCnt);
		}
		
		boolean prev = false;
		
		if (startPageBtnNo != 1) {
			prev = true;
		}
		
		Map<String, Object> pMap = new HashMap<String,Object>();
		pMap.put("next", next);
		pMap.put("prev", prev);
		pMap.put("tboardList", tboardList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		
		
		
		return pMap;
		
	}
}
