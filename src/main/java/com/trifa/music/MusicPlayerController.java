package com.trifa.music;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import db.MUSICDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MusicPlayerController {
	
	private static final Logger logger = LoggerFactory.getLogger(MusicPlayerController.class);
	
	@RequestMapping(value = "/player")
	public String home(HttpServletRequest httpServletRequest, Model model) {
		String id1 = httpServletRequest.getParameter("id");
		int che = 0;
		int id = 0;
		if(id1 != null) {
			che = 1;
			id = Integer.parseInt(httpServletRequest.getParameter("id"));
		}
		if(che == 0) {
			try {
				MUSICDAO musicdb = new MUSICDAO();
				int[] ra = musicdb.getRandomMusicId();
				
				for(int i = 0; i < 5; i++) {
					String[] info = musicdb.getMusicInfo(ra[i]);
					String atitle = musicdb.getAlbumInfo(Integer.parseInt(info[1]))[1];
					
					model.addAttribute("title" + i, info[2]);
					model.addAttribute("intro" + i, info[3]);
					model.addAttribute("artist" + i, info[4]);
					model.addAttribute("date" + i, info[5]);
					model.addAttribute("atitle" + i, atitle);
				}
							
				model.addAttribute("ra1", ra[0]);
				model.addAttribute("ra2", ra[1]);
				model.addAttribute("ra3", ra[2]);
				model.addAttribute("ra4", ra[3]);
				model.addAttribute("ra5", ra[4]);
				return "musicreadytoplay";
			}catch (Exception e) {
				e.printStackTrace();
			}
		} else if(che == 1) {
			try {
				MUSICDAO musicdb = new MUSICDAO();
					
				// ID Process
				
				String[] info = musicdb.getMusicInfo(id);
				
				//int aid = Integer.parseInt(info[1]); 
				// Album ID Process
					
				//String[] ainfo = musicdb.getAlbumInfo(aid);
				
				System.out.println(id);
				
				model.addAttribute("title", info[2]);
				model.addAttribute("intro",info[3]);
				model.addAttribute("artist", info[4]);
				model.addAttribute("date", info[5]);
				/*
				model.addAttribute("aid", aid);
				model.addAttribute("atitle", ainfo[1]);
				model.addAttribute("aintro",ainfo[2]);
				model.addAttribute("adate", ainfo[3]);
				*/
				return "musicplayer";
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "error";
	}
	
}