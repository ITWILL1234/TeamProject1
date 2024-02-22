package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.itwill.utils.DBConfig;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class Read {

    private static final String SQL_USER = "SELECT * FROM USERR WHERE EMAIL = ?";
    private static final String SQL_PRODUCT_LIST = "SELECT NUM, NAME, PRICE FROM PRODUCT";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(DBConfig.getDbUrl(), DBConfig.getDbUser(), DBConfig.getDbPassword());
    }

    public static UserVO selectUser(String email, String password) {
        String sql = SQL_USER;
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String dbPassword = rs.getString("PASSWORD");
                    if (dbPassword.equals(password)) {
                        return new UserVO(
                            rs.getString("EMAIL"),
                            dbPassword,
                            rs.getString("FIRST_NAME"),
                            rs.getString("LAST_NAME"),
                            rs.getString("GENDER"),
                            rs.getString("ADDRESS"),
                            rs.getTimestamp("CREATE_AT")
                        );
                    } else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static HashMap<Integer, ItemVO> getProductList() {
        HashMap<Integer, ItemVO> productList = new HashMap<>();
        String sql = SQL_PRODUCT_LIST;
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
            	ItemVO item = new ItemVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("PRICE"));
            	productList.put(item.getNum(), item);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    
    public static ItemVO getItem(int ItemNumber) {
    	return null;
    }
}