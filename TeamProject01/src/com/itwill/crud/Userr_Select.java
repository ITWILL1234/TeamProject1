package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.itwill.user.vo.UserVO;

public class Userr_Select {
	private String EMAIL;
	private String PASSWORD;
	private String FIRSTNAME;
	private String LASTNAME;
	private String GENDER;
	private String ADDRESS;
	private Timestamp CREATE_AT;

    public void SelectOne(String email, String password) {
    	// ** ID : ADMIN, PW: admin **  ** 테이블명  USERR  **USE 예약어라 USERR로 설정 **
    	String sql = "SELECT * FROM USERR WHERE EMAIL = ?";
        try (
        	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
        	PreparedStatement pstmt = conn.prepareStatement(sql);
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
                System.out.println();
            }
            
            if (PASSWORD.equals(password)) {
            	System.out.println("로그인이 되었습니다.");
            	UserVO user = new UserVO(EMAIL, PASSWORD, FIRSTNAME, LASTNAME, GENDER, ADDRESS, CREATE_AT);
            	System.out.println(user);
            } else {
            	System.out.println("로그인 실패!!!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
