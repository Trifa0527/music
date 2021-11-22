package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import db.MUSIC;

public class MUSICDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MUSICDAO() {
		try {
			String dbURL ="jdbc:mysql://yeonglim.cy1n2rtjhrmk.ap-northeast-2.rds.amazonaws.com/MUSIC?useSSL=false&;serverTimezone=Asia/Seoul&;useUnicode=true&characterEncoding=UTF-8\"";
			String user = "rxtx";
			String pw = "BCA2F422B80EFEE2971A4F19E5A42C1E";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int Upload(String title, String intro, String artist) {
		String SQL = "INSERT INTO INFO(ID, TITLE, INTRO, DATE, ARTIST) VALUES(?, ?, ?, NOW(), ?)";
		try {
			int i = 0;
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, i);
			pstmt.setString(1, title);
			pstmt.setString(1, intro);
			pstmt.setString(1, artist);
			rs = pstmt.executeQuery();
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public String getTitle(int id) {
		String SQL = "SELECT TITLE FROM INFO WHERE ID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "db title error";
	}
	
	public String getIntro(int id) {
		String SQL = "SELECT INTRO FROM INFO WHERE ID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "db intro error";
	}
	
	public String getDate(int id) {
		String SQL = "SELECT DATE FROM INFO WHERE ID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "db intro error";
	}
	
	public String getArtist(int id) {
		String SQL = "SELECT DATE FROM INFO WHERE ID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "db artist error";
	}
}
