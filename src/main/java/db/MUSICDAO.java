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
			String dbURL ="jdbc:mysql://yeonglim.cy1n2rtjhrmk.ap-northeast-2.rds.amazonaws.com/MUSIC?useSSL=false&;serverTimezone=Asia/Seoul&;useUnicode=true&characterEncoding=UTF-8\"";
			String user = "trifa";
			String pw = "4B0094B4BDE35526BB5A42FE9BBE5AAA";
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
	
	public String[] getMusicInfo(String id) {
		String[] music = new String[6];
		String SQL = "SELECT * FROM MUSICLIST LEFT OUTER JOIN MUSICINFO ON MUSICINFO.MUSICID = MUSICLIST.MUSICID WHERE MUSICLIST.MUSICID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				music[0] = rs.getString(1);
				music[1] = rs.getString(2);
				music[2] = rs.getString(3);
				music[3] = rs.getString(4);
				music[4] = rs.getString(5);
				music[5] = rs.getString(6);
			}
			return music;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return music;
	}
	
	public String[] getAlbumInfo(String id) {
		String[] album = new String[6];
		String SQL = "SELECT * FROM ALBUMLIST LEFT OUTER JOIN ALBUMINFO ON ALBUMINFO.ALBUMID = ALBUMLIST.ALBUMID WHERE ALBUMLIST.ALBUMID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				album[0] = rs.getString(1);
				album[1] = rs.getString(2);
				album[2] = rs.getString(3);
				album[3] = rs.getString(4);
			}
			return album;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}
}
