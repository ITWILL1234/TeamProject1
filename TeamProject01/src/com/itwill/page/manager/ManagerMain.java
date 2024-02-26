package com.itwill.page.manager;

import java.util.Scanner;

import com.itwill.page.user.Main;
import com.itwill.page.utils.ConsoleClear;
import com.itwill.vo.UserVO;

public class ManagerMain {
	private static final int PRODUCT_MANAGEMENT = 1;
	private static final int POST_MANAGEMENT = 2;
	private static final int GO_HOMEPAGE = 3;
	private static final int LOGOUT = 4;
	private static final Scanner scan = new Scanner(System.in);
	private static UserVO User;
	public static void exe(UserVO user) {
		User = user;
		displayScreen();
		processManagerChoice(getChoice());
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
		System.out.println(">> 관리자 모드를 시작합니다. <<"
				+ "\n<> 1. 상품 관리 <>"
				+ "\n<> 2. 게시물 관리 <>"
				+ "\n<> 3. 홈페이지로 돌아가기 <>"
				+ "\n<> 4. 로그아웃 <>"
				+ "\n<> 페이지를 종료하려면 'q'를 입력하세요.");
	}
	
	private static int getChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return 0;
				int inputRL = Integer.parseInt(input);
				
				if(inputRL == PRODUCT_MANAGEMENT || inputRL == POST_MANAGEMENT || inputRL == GO_HOMEPAGE || inputRL == LOGOUT) {
					return inputRL;
				} else {
					System.out.println("\n숫자 1 ~ 4 중 입력해주세요. 종료하려면 q 를 입력하세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("\n숫자 또는 q 를 입력해주세요.");
			}
		}
	}
	
	private static void processManagerChoice(int choice) {
		ConsoleClear.clear();
		
		if (choice == PRODUCT_MANAGEMENT) {
			System.out.println("상품 관리 페이지입니다.");
			ProductManagement.exe(User);
		} else if (choice == POST_MANAGEMENT) {
			System.out.println("리뷰 관리 페이지입니다.");
			// 관리 페이지 이동
		} else if (choice == GO_HOMEPAGE){
			System.out.println("홈페이지로 이동합니다..");
		} else if (choice == LOGOUT) {
			System.out.println("로그아웃에 성공했습니다.");
			System.out.println("메인 페이지입니다.");
			Main.exe();
		} else if (choice == 0) {
			System.out.println("페이지를 종료합니다.");
		}
		return;
		
	}
}