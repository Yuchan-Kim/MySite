package com.javaex.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachService {

	public void exeUpload(MultipartFile file) {
		System.out.println("AttachService.upload");
		System.out.println(file.getOriginalFilename());
	}
	
}
