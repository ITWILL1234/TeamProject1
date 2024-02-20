package com.itwill.orders_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Orders_Select {

    public static void main(String[] args) {
        try (
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ORDERS");
            ResultSet rs = stmt.executeQuery();

        ) {
        	 while (rs.next()) {
                 System.out.print(rs.getString("EMAIL") + "\t");
                 System.out.print(rs.getString("PRODUCT") + "\t");
                 System.out.print(rs.getString("ADDRESS") + "\t");
                 System.out.print(rs.getTimestamp("CREATE_AT")); // 작성시간
                 System.out.println();
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
