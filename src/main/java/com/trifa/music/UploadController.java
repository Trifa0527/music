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
	
	private static final String FILE_PATH = "/home/ubuntu/apache-tomcat-9.0.58/webapps/resources/audio/music";
	private static final String FILE_PATH2 = "/home/ubuntu/apache-tomcat-9.0.58/webapps/resources/img/albumart/cover";
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value = "/upload")
	public String home(String pw, HttpServletRequest httpServletRequest, Model model) {
		String pwd = "yoon3065015521411";
		if(pw.equals(pwd)) {
			model.addAttribute("a", "resources/upload.ico");
			return "upload";
		}
		return "error";
	}
	
	@RequestMapping(value = "/album")
	public String album(String pw, HttpServletRequest httpServletRequest, Model model) {
		String pwd = "yoon3065015521411";
		if(pw.equals(pwd)) {
			model.addAttribute("a", "resources/upload.ico");
			return "album";
		}
		return "error";
	}
	
	@RequestMapping(value = "/upload/action")
	private String saveFile(MultipartFile file, String title, String intro, String artist, int album, Model model) throws IllegalStateException, IOException{
		MUSICDAO musicdb = new MUSICDAO();
		int id = musicdb.Upload(title, intro, intro, album);
		if (id != -1) {
			String fileName = Integer.toString(id);
			file.transferTo(new File(FILE_PATH, fileName));
			
			model.addAttribute("a", "resources/complete.ico");
			return "upload";
		}
		model.addAttribute("a", "resources/cancle.ico");
		return "upload";
	}
	
	@RequestMapping(value = "/alubm/action")
	private String saveFile2(MultipartFile file, Model model) throws IllegalStateException, IOException{
		String fileName = file.getOriginalFilename();
		file.transferTo(new File(FILE_PATH2, fileName));
		
		model.addAttribute("a", "resources/complete.ico");
		return "album";
	}
}