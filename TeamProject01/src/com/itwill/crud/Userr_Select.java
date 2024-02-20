package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Userr_Select {

    public static void main(String[] args) {
    	// ** ID : ADMIN, PW: admin **  ** 테이블명  USERR  **USE 예약어라 USERR로 설정 **
        try (
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERR");
            ResultSet rs = stmt.executeQuery();
        ) {
            // 결과 처리
            while (rs.next()) {
                System.out.print(rs.getString("EMAIL") + "\t");
                System.out.print(rs.getString("PASSWORD") + "\t");
                System.out.print(rs.getString("GENDER") + "\t");
                System.out.print(rs.getString("FIRST_NAME") + "\t");
                System.out.print(rs.getString("LAST_NAME") + "\t");
                System.out.print(rs.getString("ADDRESS") + "\t");
                System.out.print(rs.getTimestamp("CREATE_AT")); // 작성시간
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
