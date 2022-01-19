package com.trifa.music;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import db.MUSICDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MusicPlayerController {
	
	private static final Logger logger = LoggerFactory.getLogger(MusicPlayerController.class);
	
	@RequestMapping(value = "/player/{title}")
	public String home(@PathVariable("title") String title, Locale locale, Model model) {
		
		MUSICDAO musicdao = new MUSICDAO();
		title = title.replace("_", " ");
		int id = musicdao.getID(title);
		String intro = musicdao.getIntro(id);
		String artist = musicdao.getArtist(id);
		String date = musicdao.getDate(id);
		date = date.replace("-", ".");
		
		model.addAttribute("title", title);
		model.addAttribute("intro", intro);
		model.addAttribute("artist", artist);
		model.addAttribute("date", date);
		
		return "musicplayer";
	}
	
}
