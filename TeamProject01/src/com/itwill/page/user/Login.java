package com.itwill.page.user;

import com.itwill.crud.Read;
import com.itwill.utils.UserInputScanner;
import com.itwill.vo.UserVO;

public class Login {
	private static String EMAIL;
	private static String PASSWORD;
	private static UserVO User;
	
	public static void exe() {
		ResetValue();
		displayScreen();
		scanInput();
		loadUserFromOracle();
	}
	
	private static void ResetValue() {
		EMAIL = null;
		PASSWORD = null;
	}

	private static void displayScreen() {
		System.out.println(""
				+ "\n"
				+ "██╗      ██████╗  ██████╗ ██╗███╗   ██╗\n"
				+ "██║     ██╔═══██╗██╔════╝ ██║████╗  ██║\n"
				+ "██║     ██║   ██║██║  ███╗██║██╔██╗ ██║\n"
				+ "██║     ██║   ██║██║   ██║██║██║╚██╗██║\n"
				+ "███████╗╚██████╔╝╚██████╔╝██║██║ ╚████║\n"
				+ "╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝\n"
				+ "                                       \n"
				+ "");
		System.out.println(">> 로그인을 시작합니다.");
	}
	
	/* 
	 * 이메일과 비밀번호를 입력받는 코드입니다. (Scanner 사용)
	 */ 
	private static void scanInput() {
		EMAIL = UserInputScanner.scanEmail();
        PASSWORD = UserInputScanner.scanPassword();
	}
	
	/* 오라클의 user테이블에서 WHERE EMAIL 조회를 하여,
     * 비밀번호가 맞는지 확인하는 코드입니다.
     */
	private static void loadUserFromOracle() {
		if ((User = Read.SelectUser(EMAIL, PASSWORD)) != null) {
        	ConsoleClear.clear();
        	System.out.println("로그인에 성공하였습니다!");
        	System.out.println("홈페이지로 이동합니다.");
        	Homepage.exe(User);
        } else {
        	ConsoleClear.clear();
        	System.out.println("로그인에 실패하였습니다.");
        	exe();
        }
	}
	
}