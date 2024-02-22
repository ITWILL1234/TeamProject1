package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.itwill.utils.DBConfig;
import com.itwill.vo.UserVO;

public class Read {
	private static final String DB_URL = DBConfig.getDbUrl();
    private static final String DB_USER = DBConfig.getDbUser();
    private static final String DB_PASS = DBConfig.getDbPassword();
	private static String EMAIL;
	private static String PASSWORD;
	private static String FIRSTNAME;
	private static String LASTNAME;
	private static String GENDER;
	private static String ADDRESS;
	private static Timestamp CREATE_AT;
	
	private static final String SQL = "SELECT * FROM USERR WHERE EMAIL = ?";

    public static UserVO SelectUser(String email, String password) {
    	// ** ID : ADMIN, PW: admin **  ** 테이블명  USERR  **USE 예약어라 USERR로 설정 **
        try (
        	Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        	PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            // 결과 처리
        	pstmt.setString(1, email);
        	ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                EMAIL = rs.getString("EMAIL");
                PASSWORD = rs.getString("PASSWORD");
                GENDER = rs.getString("GENDER");
                FIRSTNAME = rs.getString("FIRST_NAME");
                LASTNAME = rs.getString("LAST_NAME");
                ADDRESS = rs.getString("ADDRESS");
                CREATE_AT = rs.getTimestamp("CREATE_AT"); // 작성시간
            }
            
            if (PASSWORD.equals(password)) {
            	return new UserVO(EMAIL, PASSWORD, FIRSTNAME, LASTNAME, GENDER, ADDRESS, CREATE_AT);
            } else {
            	System.out.println("비밀번호가 일치하지 않습니다.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}