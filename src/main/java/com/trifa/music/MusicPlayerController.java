package com.trifa.music;

import java.sql.PreparedStatement;
import java.util.Objects;

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
public class MusicPlayerController {
	
	private static final Logger logger = LoggerFactory.getLogger(MusicPlayerController.class);
	
	@RequestMapping(value = "/player", method=RequestMethod.POST)
	public String home(HttpServletRequest httpServletRequest, Model model) {
		String test = "suc";
		if(test.equals(httpServletRequest.getParameter("che"))) {
			if(Objects.equals(null, httpServletRequest.getParameter("id"))) {
				return "musicreadytoplay";
			} else {
				try {
					MUSICDAO musicdb = new MUSICDAO();
					
					int id = Integer.parseInt(httpServletRequest.getParameter("id"));
					// ID Process
					
					String[] info = musicdb.getMusicInfo(id);
					
					int aid = Integer.parseInt(info[1]);
					// Album ID Process
					
					model.addAttribute("title", info[2]);
					model.addAttribute("intro",info[3]);
					model.addAttribute("artist", info[4]);
					model.addAttribute("date", info[5]);
					
					return "musicplayer";
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
			
		return "error";
	}
	
}
