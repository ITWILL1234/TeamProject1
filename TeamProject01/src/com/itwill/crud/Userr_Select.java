package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.itwill.page.*;
import com.itwill.vo.UserVO;

public class Userr_Select {
	private static String EMAIL;
	private static String PASSWORD;
	private static String FIRSTNAME;
	private static String LASTNAME;
	private static String GENDER;
	private static String ADDRESS;
	private static Timestamp CREATE_AT;
	
	private static final String SQL = "SELECT * FROM USERR WHERE EMAIL = ?";
	
	private UserVO user;

    public void SelectOne(String email, String password) {
    	// ** ID : ADMIN, PW: admin **  ** 테이블명  USERR  **USE 예약어라 USERR로 설정 **
        try (
        	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
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
                System.out.println();
            }
            
            if (PASSWORD.equals(password)) {
            	System.out.println("로그인이 되었습니다.");
            	user = new UserVO(EMAIL, PASSWORD, FIRSTNAME, LASTNAME, GENDER, ADDRESS, CREATE_AT);
            	Homepage.exe(user);
            } else {
            	System.out.println("로그인 실패!!!");
            	Login.exe();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    
    // 회원정보 수정을 한 후에, 수정된 회원 정보를 로컬로 가져오기 위한 코드입니다.
    public static void updateLocalUser(String email) {
        try (
        	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
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
            
            EditProfile.exe(new UserVO(EMAIL, PASSWORD, FIRSTNAME, LASTNAME, GENDER, ADDRESS, CREATE_AT));
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return;
    }
}
