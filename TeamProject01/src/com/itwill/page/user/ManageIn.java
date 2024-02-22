package com.itwill.page.user;

import java.util.HashMap;

import com.itwill.crud.CUD;
import com.itwill.utils.ManagerInputScanner;
import com.itwill.utils.UserInputScanner;

public class ManageIn {
	private static String EMAIL;
	private static String PASSWORD;
	private static String MANAGER;
	
	private static final String SQL = "INSERT INTO USERR (EMAIL, PASSWORD, GENDER, FIRST_NAME, LAST_NAME, ADDRESS, CREATE_AT) "
			   + "VALUES (?, ?, ?, ?, ?, ?, SYSDATE)";
	
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
	
	
	
}
