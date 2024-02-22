package com.itwill.crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itwill.vo.ItemVO;

public class ProductDAO {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private static final String DB_USER = "ADMIN"; 
    private static final String DB_PASSWORD = "admin"; 

    // product 테이블의 데이터를 가져오는 메서드
    public static ArrayList<ItemVO> getProductList() {
        ArrayList<ItemVO> productList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL 쿼리 실행
            String sql = "SELECT NUM, NAME, PRICE FROM PRODUCT";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                int num = rs.getInt("NUM");
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                ItemVO product = new ItemVO(num, name, price);
                productList.add(product);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return productList;
    }
}
