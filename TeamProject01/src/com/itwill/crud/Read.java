package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.itwill.utils.Config;
import com.itwill.vo.ItemVO;
import com.itwill.vo.PostVO;
import com.itwill.vo.UserVO;

public class Read {

    private static final String SQL_USER = "SELECT * FROM USERR WHERE EMAIL = ? ";
    private static final String SQL_PRODUCT_LIST = "SELECT NUM, NAME, PRICE, IMAGE FROM PRODUCT ";
    private static final String SQL_ITEM = "SELECT * FROM PRODUCT WHERE NUM = ? ";
    private static final String SQL_POST = "SELECT * FROM POST WHERE ITEMNUM = ? ";
    private static final String SQL_CHECK_ORDER_HISTORY = "SELECT COUNT(*) FROM ORDERS WHERE CUSTOMEREMAIL = ? AND PRODUCTNUM = ? ";
    

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPassword());
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
                    	System.out.println("비밀번호가 일치합니다.");
                        return new UserVO(
                            rs.getString("EMAIL"),
                            rs.getString("PASSWORD"),
                            rs.getString("FIRST_NAME"),
                            rs.getString("LAST_NAME"),
                            rs.getString("GENDER"),
                            rs.getString("ADDRESS"),
                            rs.getTimestamp("CREATE_AT"),
                            rs.getString("MANAGER")
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
            	ItemVO item = new ItemVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("PRICE"), rs.getString("IMAGE"));
            	productList.put(item.getNum(), item);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    
    public static ItemVO selectItem(int itemNum) {
    	String sql = SQL_ITEM;
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

               pstmt.setInt(1, itemNum);
               try (ResultSet rs = pstmt.executeQuery()) {
               
		           while (rs.next()) {
		        	   return new ItemVO(
		        			   rs.getInt("NUM"),
		        			   rs.getString("NAME"),
		        			   rs.getInt("PRICE"),		   
		        			   rs.getString("IMAGE"));
		           }
               }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return null;
    }
    
    public static ArrayList<PostVO> getPost(int itemNum) {
        String sql = SQL_POST;
        
        ArrayList<PostVO> postList = new ArrayList<>(); 

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, itemNum);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                PostVO postVO = new PostVO(rs.getInt("NUM"), rs.getInt("ITEMNUM"), rs.getString("TITLE"), rs.getString("DESCRIPTION"), rs.getString("EMAIL"), rs.getTimestamp("CREATEDAT"));
                postList.add(postVO);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public static String checkOrderHistory(String email, int itemNum) {
    	String sql = SQL_CHECK_ORDER_HISTORY;
    	
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
        	pstmt.setString(1, email);
        	pstmt.setInt(2, itemNum);
        	ResultSet rs = pstmt.executeQuery();
        	while (rs.next()) {
        		System.out.println(rs.getInt("COUNT(*)"));
        		if(rs.getInt("COUNT(*)") > 0) return "TRUE"; 
        	}
        } catch (ClassNotFoundException | SQLException e) {
               e.printStackTrace();
           }
           return "FALSE";
      }
}