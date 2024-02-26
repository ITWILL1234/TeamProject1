package com.itwill.page.user;

import java.util.HashMap;

import com.itwill.page.utils.ConsoleClear;
import com.itwill.socket.client.ClientSignIn;
import com.itwill.utils.UserInputScanner;

public class SignIn {
	private static String EMAIL;
	private static String PASSWORD;
	private static String FIRSTNAME;
	private static String LASTNAME;
	private static String GENDER;
	private static String ADDRESS;
	
	public static void exe() {
		displayScreen();
		resetValue();
		scanUserInput();
		proceedInsertOracle();
		
		return;
	}
	
	private static void displayScreen() {
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
	}
	
	private static void resetValue() {
		EMAIL = null;
		PASSWORD = null;
		FIRSTNAME = null;
		LASTNAME = null;
		GENDER = null;
		ADDRESS = null;
	}
	
	private static void scanUserInput() {
		EMAIL = UserInputScanner.scanEmail();
        PASSWORD = UserInputScanner.scanPassword();
        FIRSTNAME = UserInputScanner.scanFirstName();
        LASTNAME = UserInputScanner.scanLastName();
        GENDER = UserInputScanner.scanGender();
		ADDRESS = UserInputScanner.scanAddress();
	}
	
	private static HashMap<Integer, String>createSqlPair() {
		HashMap<Integer, String> pair = new HashMap<Integer, String>();
		pair.put(1, EMAIL);
		pair.put(2, PASSWORD);
		pair.put(3, FIRSTNAME);
		pair.put(4, LASTNAME);
		pair.put(5, GENDER);
		pair.put(6, ADDRESS);
		return pair;
	}
	
	private static void proceedInsertOracle() {
		ClientSignIn clientSignIn = new ClientSignIn();
		clientSignIn.start(createSqlPair());
		if (clientSignIn.getResult()) {
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
