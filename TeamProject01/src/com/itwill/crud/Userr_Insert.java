package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Userr_Insert {

	public static void main(String[] args) {
    	// ** ID : ADMIN, PW: admin **  ** 테이블명  USERR  **USE 예약어라 USERR로 설정 **
        try (
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
            Statement stmt = conn.createStatement();
        ) {
        	String sql = "INSERT INTO USERR (EMAIL, PASSWORD, GENDER, FIRST_NAME, LAST_NAME, ADDRESS, CREATE_AT) "
        			   + "VALUES ('WDDDASSDA@ASD.COM', '1122', '남', '김', '철수','강남어딘가', SYSDATE)";
		   
        	System.out.println("sql : " + sql);
        	int result = stmt.executeUpdate(sql);
			System.out.println("처리건수 : " + result);
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
