package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itwill.vo.UserVO;
import com.itwill.page.*;
import com.itwill.utils.DBConfig;
import com.itwill.utils.UserInputScanner;

public class Userr_Update {
    private static final int CHANGE_PASSWORD = 1;
    private static final int CHANGE_ADDRESS = 2;
    private static final String PASSWORD_SQL = "UPDATE USERR SET PASSWORD = ? WHERE EMAIL = ?";
    private static final String ADDRESS_SQL = "UPDATE USERR SET ADDRESS = ? WHERE EMAIL = ?";
    private static final ArrayList<String> CHANGED = new ArrayList<>();
    private static final String DB_URL = DBConfig.getDbUrl();
    private static final String DB_USER = DBConfig.getDbUser();
    private static final String DB_PASS = DBConfig.getDbPassword();

    private static UserVO User;

    static {
    	CHANGED.add("null");
        CHANGED.add("비밀번호");
        CHANGED.add("주소");
    }

    public static void edit(UserVO user, int type) {
        User = user;
        String newValue = checkScanType(type);

        try (
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            PreparedStatement pstmt = conn.prepareStatement(checkEditType(type));
        ) {
            pstmt.setString(1, newValue);
            pstmt.setString(2, user.getEMAIL());
            int result = pstmt.executeUpdate();

            ConsoleClear.clear();
            
            if (result == 0) {
                System.out.println("회원정보가 수정되지 않았습니다! 관리자에게 문의하세요!");
            } else {
                System.out.println(CHANGED.get(type) + "가 수정되었습니다");
            }
            // 회원정보 수정 페이지로 리디렉션
            Userr_Select.updateLocalUser(User.getEMAIL());
            return;

        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 또는 쿼리 실행 중 오류가 발생했습니다. 관리자에게 문의하세요.");
        }
    }

    private static String checkEditType(int type) {
        if (type == CHANGE_PASSWORD) {
            return PASSWORD_SQL;
        } else if (type == CHANGE_ADDRESS) {
            return ADDRESS_SQL;
        } else {
            return null;
        }
    }

    private static String checkScanType(int type) {
        if (type == CHANGE_PASSWORD) {
            return UserInputScanner.scanPassword();
        } else if (type == CHANGE_ADDRESS) {
            return UserInputScanner.scanAddress();
        } else {
        	System.out.println("null값이 스캔되었습니다. Userr_Update를 확인하세요.");
            return null;
        }
    }
}
