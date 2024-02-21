package com.itwill.page;

import java.util.Scanner;

import com.itwill.vo.UserVO;
import com.itwill.crud.Userr_Update;

public class EditProfile {
	private static final int CHANGE_PASSWORD = 1;
	private static final int CHANGE_ADDRESS = 2;
	private static final int GO_HOME = 3;
	private static final int QUIT = 4;
	
	private static UserVO User;
	
	private static final Scanner scan = new Scanner(System.in);
	
	public static void exe(UserVO user) {
		User = user;
		display();
		processUserChoice(getUserChoice());
		
	}
	private static void display() {
		System.out.println(""
				+ "\n"
				+ "███████╗██████╗ ██╗████████╗    ██████╗ ██████╗  ██████╗ ███████╗██╗██╗     ███████╗\n"
				+ "██╔════╝██╔══██╗██║╚══██╔══╝    ██╔══██╗██╔══██╗██╔═══██╗██╔════╝██║██║     ██╔════╝\n"
				+ "█████╗  ██║  ██║██║   ██║       ██████╔╝██████╔╝██║   ██║█████╗  ██║██║     █████╗  \n"
				+ "██╔══╝  ██║  ██║██║   ██║       ██╔═══╝ ██╔══██╗██║   ██║██╔══╝  ██║██║     ██╔══╝  \n"
				+ "███████╗██████╔╝██║   ██║       ██║     ██║  ██║╚██████╔╝██║     ██║███████╗███████╗\n"
				+ "╚══════╝╚═════╝ ╚═╝   ╚═╝       ╚═╝     ╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝╚══════╝\n"
				+ "                                                                                    \n"
				+ "");
		System.out.println(""
				+ "<> 콘솔창에 원하는 메뉴를 입력해 주세요! <>\n"
				+ "<> 1. 비밀번호 변경 <>\n"
				+ "<> 2. 주소 변경 <>\n"
				+ "<> h. 홈페이지로 이동 <>\n"
				+ "<> q. 종료 <>");
	}
	private static int getUserChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("H")) {
					return GO_HOME;
				}
				else if (input.equalsIgnoreCase("Q")) {
					return QUIT;
				}
				
				int inputRL = Integer.parseInt(input);
				if (inputRL == CHANGE_PASSWORD || inputRL == CHANGE_ADDRESS) {
					return inputRL;
				}
			} catch (NumberFormatException e) {
				System.out.println("\n숫자로 입력해주세요.");
			}
		}
	}
	private static void processUserChoice(int choice) {
		ConsoleClear.clear();
		
		if (choice == CHANGE_PASSWORD || choice == CHANGE_ADDRESS) {
			Userr_Update.edit(User, choice);
		} else if (choice == GO_HOME) {
			System.out.println("홈페이지로 이동합니다.");
			Homepage.exe(User);
		} else if (choice == QUIT) {
			System.out.println("시스템을 종료합니다.");
		} else {
			System.out.println("문제가 발생했습니다. 관리자에게 문의해주세요!!");
		}
		return;
	}
	
}
