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
			String dbURL ="jdbc:mysql://yeonglim.cy1n2rtjhrmk.ap-northeast-2.rds.amazonaws.com/MUSIC?serverTimezone=UTC";
			String user = "rxtx";
			String pw = "BCA2F422B80EFEE2971A4F19E5A42C1E";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public 
}
