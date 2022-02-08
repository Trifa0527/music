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
	
	@RequestMapping(value = "/player")
	public String home(HttpServletRequest httpServletRequest, Model model) {
		String test = "suc";
		if(test.equals(httpServletRequest.getParameter("che"))) {
			if(Objects.equals(null, httpServletRequest.getParameter("id"))) {
				try {
					int[] ra = {1, 2, 3, 4, 5};
					
					model.addAttribute("title", "Title 제목");
					model.addAttribute("intro","Intro 인트로");
					model.addAttribute("artist", "Artist 제작자");
					model.addAttribute("date", "2022.02.04");
					model.addAttribute("atitle", "Album 앨범");
					
					model.addAttribute("ra1", ra[0]);
					model.addAttribute("ra2", ra[1]);
					model.addAttribute("ra3", ra[2]);
					model.addAttribute("ra4", ra[3]);
					model.addAttribute("ra5", ra[4]);
					return "musicreadytoplay";
				}catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					MUSICDAO musicdb = new MUSICDAO();
					
					int id = Integer.parseInt(httpServletRequest.getParameter("id"));
					// ID Process
					
					String[] info = musicdb.getMusicInfo(id);
					
					int aid = Integer.parseInt(info[1]);
					// Album ID Process
					
					String[] ainfo = musicdb.getAlbumInfo(aid);
					
					model.addAttribute("title", info[2]);
					model.addAttribute("intro",info[3]);
					model.addAttribute("artist", info[4]);
					model.addAttribute("date", info[5]);
					
					model.addAttribute("aid", aid);
					model.addAttribute("atitle", ainfo[1]);
					model.addAttribute("aintro",ainfo[2]);
					model.addAttribute("adate", ainfo[3]);
					
					return "musicplayer";
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
			
		return "error";
	}
	
}