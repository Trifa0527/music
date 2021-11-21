package db;

import java.util.Date;

public class MUSIC {
	private int musicID;
	private String musicTitle;
	private String musicIntro;
	private Date musicDate;
	
	public int getMusicID() {
		return musicID;
	}
	public void setMusicID(int musicID) {
		this.musicID = musicID;
	}
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getMusicIntro() {
		return musicIntro;
	}
	public void setMusicIntro(String musicIntro) {
		this.musicIntro = musicIntro;
	}
	public Date getMusicDate() {
		return musicDate;
	}
	public void setMusicDate(Date musicDate) {
		this.musicDate = musicDate;
	}
}
