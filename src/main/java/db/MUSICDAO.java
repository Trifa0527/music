package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class MUSICDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MUSICDAO() {
		try {
			String dbURL ="jdbc:mysql://database.cvh4qmchwbxh.ap-northeast-2.rds.amazonaws.com:3306/MUSIC";
			String user = "trifa";
			String pw = "4B0094B4BDE35526BB5A42FE9BBE5AAA";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int Upload(String title, String intro, String artist, int alId) {
		String SQL = "INSERT INTO MUSICINFO(MUSICID, ALBUMID, MUSICTITLE, MUSICINTRO, MUSICARTIST, MUSICDATE) VALUES(?, ?, ?, ?, ?, NOW())";
		try {
			int i = 0;
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, i);
			pstmt.setInt(2, alId);
			pstmt.setString(3, title);
			pstmt.setString(4, intro);
			pstmt.setString(5, artist);
			aUpdate(alId);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int aUpdate(int aid) {
		String SQL = "UPDATE ALBUMINFO ALBUMDATE = NOW() WHERE ALBUMID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, aid);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int createAlbum(String title, String intro) {
		String SQL = "INSERT INTO ALBUMINFO(ALBUMID, ALBUMTITLE, ALBUMINTRO, ALBUMDATE) VALUES(?, ?, ?, NOW())";
		try {
			int i = 0;
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, i);
			pstmt.setString(2, title);
			pstmt.setString(3, intro);
			rs = pstmt.executeQuery();
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public String[] getMusicInfo(int id) {
		String[] music = new String[6];
		String SQL = "SELECT * FROM MUSICINFO WHERE MUSICID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				music[0] = rs.getString(1);		// ID
				music[1] = rs.getString(2);		// Album Id
				music[2] = rs.getString(3);		// Title
				music[3] = rs.getString(4);		// Intro
				music[4] = rs.getString(5);		// Artist
				music[5] = rs.getString(6);		// Date
			}
			return music;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return music;
	}
	
	public String[] getAlbumInfo(int id) {
		String[] album = new String[4];
		String SQL = "SELECT * FROM ALBUMINFO WHERE ALBUMID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				album[0] = rs.getString(1);		// Album Id
				album[1] = rs.getString(2);		// Album Ttile
				album[2] = rs.getString(3);		// Album Intro
				album[3] = rs.getString(4);		// Album Date 
			}
			return album;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}
	
	public int[] getMusicIdInAlbum(int id) {
		int[] ids = new int[11];
		String SQL = "SELECT MUSICINFO.MUSICID FROM ALBUMINFO LEFT JOIN MUSICINFO ON MUSICINFO.ALBUMID = ALBUMINFO.ALBUMID WHERE ALBUMINFO.ALBUMID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				ids[i] = rs.getInt(1);
				i++;
			}
			return ids;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ids;
	}
	
	public int[] getRandomMusicId() {
		int[] ra = new int[5];
		String SQL = "SELECT MUSICID FROM MUSICINFO ORDER BY RAND() LIMIT 5";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				ra[i] = rs.getInt(1);
				i++;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ra;
	}
}
