package com.trifa.music;

import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import db.MUSICDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MusicMainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MusicPlayerController.class);
	
	@RequestMapping(value = "/")
	public String home(HttpServletRequest httpServletRequest, Model model) {
		
		return "musicmain";
	}
}
