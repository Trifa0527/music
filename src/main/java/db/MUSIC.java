package db;

import java.util.Date;

public class MUSIC {
	private int musicID;			// 식별 목적
	private String musicTitle;		// 곡 제목
	private String musicIntro;		// 곡 소개, 설명
	private Date musicDate;			// 업로드 날짜
	
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
