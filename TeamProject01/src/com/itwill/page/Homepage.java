package com.itwill.page;

import java.util.Scanner;

import com.itwill.user.vo.UserVO;

public class Homepage {
	private static int product = 1;
	private static int review = 2;
	private static int qna = 3;
	private static int logout = 4;
	private static int deleteAccount = 5;
	private static final Scanner scan = new Scanner(System.in);
	
	private static UserVO User;

	public static void exe(UserVO user) {
		User = user;
		displayHomeScreen();
		int inputRL = getUesrChoice();
		processUserChoice(inputRL);
	}

	private static void displayHomeScreen() {
		System.out.println(""
				+ "\r\n"
				+ "██╗  ██╗ ██████╗ ███╗   ███╗███████╗        ██████╗  █████╗  ██████╗ ███████╗\r\n"
				+ "██║  ██║██╔═══██╗████╗ ████║██╔════╝        ██╔══██╗██╔══██╗██╔════╝ ██╔════╝\r\n"
				+ "███████║██║   ██║██╔████╔██║█████╗          ██████╔╝███████║██║  ███╗█████╗  \r\n"
				+ "██╔══██║██║   ██║██║╚██╔╝██║██╔══╝          ██╔═══╝ ██╔══██║██║   ██║██╔══╝  \r\n"
				+ "██║  ██║╚██████╔╝██║ ╚═╝ ██║███████╗███████╗██║     ██║  ██║╚██████╔╝███████╗\r\n"
				+ "╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝╚══════╝╚═╝     ╚═╝  ╚═╝ ╚═════╝ ╚══════╝\r\n"
				+ "                                                                             \r\n"
				+ "");
		System.out.println("<> 1. 상품 2. 리뷰 3. 문의 4. 로그아웃 5. 회원탈퇴 <>");
		System.out.println("<> 페이지를 종료하려면 'q'를 입력하세요.<>");
	}
	
	private static int getUesrChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return 0;
				int inputRL = Integer.parseInt(input);
				
				if(inputRL == product || inputRL == review || inputRL == qna || inputRL == logout || inputRL == deleteAccount) {
					return inputRL;
				} else {
					System.out.println("\n숫자 1 ~ 5 중 입력해주세요. 종료하려면 q 를 입력하세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("\n숫자 또는 q 를 입력해주세요.");
			}
		}
	}
	
	private static void processUserChoice(int choice) {
		ConsoleClear.clear();
		
		if (choice == product) {
			System.out.println("상품목록 페이지입니다.");
			// ProductList.exe(User);
		} else if (choice == review) {
			System.out.println("리뷰 페이지입니다.");
			// Review.exe(User);
		} else if (choice == qna) {
			System.out.println("문의 페이지입니다.");
			// QnA.exe(User);
		} else if (choice == logout) {
			System.out.println("로그아웃에 성공했습니다.");
			System.out.println("메인 페이지입니다.");
			Main.exe();
		} else if (choice == deleteAccount) {
			System.out.println("회원탈퇴 페이지입니다.");
			SignOut.exe(User);
		} else if (choice == 0) {
			System.out.println("페이지를 종료합니다.");
		}
		return;
		
	}
	

}
