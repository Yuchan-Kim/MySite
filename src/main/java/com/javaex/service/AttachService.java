package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.AttachVo;

@Service
public class AttachService {

	public String exeUpload(MultipartFile file)  {
		System.out.println("AttachService.upload");
		System.out.println(file.getOriginalFilename());
		
		//사진의 기본정보들을 추출한다.
		
		//1.파일명
		String orgName = file.getOriginalFilename();
		System.out.println("orgName: " + orgName);
		
		//2.확장자
		String exeName =orgName.substring(orgName.lastIndexOf("."));
		System.out.println(exeName);
		
		//3.파일 사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);
		
		//저장 파일명(겹치지 않아야함)
		//String saveName = UUID.randomUUID().toString();
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+exeName;
		System.out.println(saveName);
		
		//파일 경로
		String saveDir = "/Users/yuchan/Desktop/photos";
		
		//파일 경로+ 파일명
		String filePath = saveDir + "/" + saveName;
		System.out.println(filePath);
		
		//Save in DB
		AttachVo attachVo = new AttachVo (orgName, saveName, filePath, fileSize);
		System.out.println(attachVo);
		
		//로컬 저장공간에 파일을 저장.
		//과제 (Dao, XML)
		
		//사진을 서버에 복사한다
		//파일저장
		try {
			byte[] fileData = file.getBytes();
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os); //한번에 바이트 데이터를 모아서 보냄. 속도가 빨라짐.
			bos.write(fileData);
		}catch(IOException e) {
			System.out.println("Error: " + e);
		}
		
		return saveName;
		
		
		
		
	}
	
}