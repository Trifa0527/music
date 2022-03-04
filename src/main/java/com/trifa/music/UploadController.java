package com.trifa.music;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import db.MUSICDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UploadController {
	
	private static final String FILE_PATH = "/home/ubuntu/apache-tomcat-9.0.58/webapps/resources/audio";
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value = "/upload")
	public String home(String pw, HttpServletRequest httpServletRequest, Model model) {
		String pwd = "yoon3065015521411";
		if(pw.equals(pwd)) {
			return "upload";
		}
		return "error";
	}
	
	@RequestMapping(value = "/album")
	public String album(String pw, HttpServletRequest httpServletRequest, Model model) {
		String pwd = "yoon3065015521411";
		if(pw.equals(pwd)) {
			return "album";
		}
		return "error";
	}
	
	@RequestMapping(value = "/upload/action")
	private String saveFile(MultipartFile file) throws IllegalStateException, IOException{
		String fileName = file.getOriginalFilename();
		file.transferTo(new File(FILE_PATH, fileName));
		return "upload";
	}
}