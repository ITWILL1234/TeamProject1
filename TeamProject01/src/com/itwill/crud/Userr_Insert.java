package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itwill.user.vo.UserVO;
import com.itwill.user.scanner.userscanner;

public class Userr_Insert {

	public void start() {
    	// ** ID : ADMIN, PW: admin **  ** 테이블명  USERR  **USE 예약어라 USERR로 설정 **
		
		String sql = "INSERT INTO USERR (EMAIL, PASSWORD, GENDER, FIRST_NAME, LAST_NAME, ADDRESS, CREATE_AT) "
				   + "VALUES ('?', '?', '?', '?', '?','?', SYSDATE)";
		
		userscanner uc = new userscanner();
		UserVO user = uc.register();
		
        try (
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
        	int i = 1;
        	pstmt.setString(i++, user.getEMAIL());
        	pstmt.setString(i++, user.getPASSWORD());
        	pstmt.setString(i++, user.getGENDER());
        	pstmt.setString(i++, user.getFIRSTNAME());
        	pstmt.setString(i++, user.getLASTNAME());
        	pstmt.setString(i++, user.getADDRESS());
		   
        	System.out.println("sql : " + sql);
        	int result = pstmt.executeUpdate(sql);
			System.out.println("처리건수 : " + result);
			if (result == 0) {
				System.out.println("회원가입이 되지 않았습니다! 관리자에게 문의하세요!");
			}
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
