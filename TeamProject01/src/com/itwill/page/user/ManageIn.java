package com.itwill.page.user;

import java.util.HashMap;

import com.itwill.crud.CUD;
import com.itwill.crud.Read;
import com.itwill.utils.ManagerInputScanner;
import com.itwill.utils.UserInputScanner;

public class ManageIn {
	private static String EMAIL;
	private static String PASSWORD;
	private static String MANAGER;
	
	public static void exe() {
		displayScreen();
		resetValue();
		scanManagerInput();

		return;
	}
	
	private static void displayScreen() {
		System.out.println(""
				+ "\n"
				+ "\r\n"
				+ "███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗███╗   ███╗ ██████╗ ██████╗ ███████╗\r\n"
				+ "████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝████╗ ████║██╔═══██╗██╔══██╗██╔════╝\r\n"
				+ "██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██╔████╔██║██║   ██║██║  ██║█████╗  \r\n"
				+ "██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██║╚██╔╝██║██║   ██║██║  ██║██╔══╝  \r\n"
				+ "██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║ ╚═╝ ██║╚██████╔╝██████╔╝███████╗\r\n"
				+ "╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝\r\n"
				+ "                                                                                          \r\n"
				+ "");
		System.out.println(">> 관리자 모드를 시작합니다. ");
	}
	
	private static void resetValue() {
		EMAIL = null;
		PASSWORD = null;
		MANAGER = null;
	}
	
	private static void scanManagerInput() {
		EMAIL = ManagerInputScanner.scanEmail();
        PASSWORD = ManagerInputScanner.scanPassword();
        //MANAGER = ManagerInputScanner.scanManager();
	}
	
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
