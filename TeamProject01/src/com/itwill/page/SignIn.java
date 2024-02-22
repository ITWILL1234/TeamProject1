package com.itwill.page;

import java.util.HashMap;

import com.itwill.crud.CUD;
import com.itwill.utils.UserInputScanner;

public class SignIn {
	private static String EMAIL;
	private static String PASSWORD;
	private static String FIRSTNAME;
	private static String LASTNAME;
	private static String GENDER;
	private static String ADDRESS;
	
	private static final String SQL = "INSERT INTO USERR (EMAIL, PASSWORD, GENDER, FIRST_NAME, LAST_NAME, ADDRESS, CREATE_AT) "
			   + "VALUES (?, ?, ?, ?, ?, ?, SYSDATE)";
	
	public static void exe() {
		System.out.println(""
				+ "\n"
				+ "██████╗ ███████╗ ██████╗ ██╗███████╗████████╗██████╗  █████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n"
				+ "██╔══██╗██╔════╝██╔════╝ ██║██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n"
				+ "██████╔╝█████╗  ██║  ███╗██║███████╗   ██║   ██████╔╝███████║   ██║   ██║██║   ██║██╔██╗ ██║\n"
				+ "██╔══██╗██╔══╝  ██║   ██║██║╚════██║   ██║   ██╔══██╗██╔══██║   ██║   ██║██║   ██║██║╚██╗██║\n"
				+ "██║  ██║███████╗╚██████╔╝██║███████║   ██║   ██║  ██║██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║\n"
				+ "╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n"
				+ "                                                                                            \n"
				+ "");
		System.out.println(">> 회원가입을 시작합니다.");
		ResetValue();
		
		// 유저의 입력을 받는 코드입니다.
        EMAIL = UserInputScanner.scanEmail();
        PASSWORD = UserInputScanner.scanPassword();
        FIRSTNAME = UserInputScanner.scanFirstName();
        LASTNAME = UserInputScanner.scanLastName();
        GENDER = UserInputScanner.scanGender();
		ADDRESS = UserInputScanner.scanAddress();
		
		ProceedInsertOracle();
		
		return;
	}	
	
	private static void ResetValue() {
		EMAIL = null;
		PASSWORD = null;
		FIRSTNAME = null;
		LASTNAME = null;
		GENDER = null;
		ADDRESS = null;
	}
	
	private static HashMap<Integer, String>CreateSqlPair() {
		HashMap<Integer, String> pair = new HashMap<Integer, String>();
		pair.put(1, EMAIL);
		pair.put(2, PASSWORD);
		pair.put(3, FIRSTNAME);
		pair.put(4, LASTNAME);
		pair.put(5, GENDER);
		pair.put(6, ADDRESS);
		return pair;
	}
	
	private static void ProceedInsertOracle() {
		if (CUD.exe(SQL, CreateSqlPair())) {
			ConsoleClear.clear();
			System.out.println("회원가입에 성공했습니다. 로그인페이지로 리디렉션 합니다.");
			System.out.println();
			Login.exe();
		} else {
			System.out.println("회원가입에 실패했습니다. 다시 진행해주세요.");
			Main.exe();
		}
	}
}
