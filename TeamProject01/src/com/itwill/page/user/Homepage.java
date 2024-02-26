package com.itwill.page.user;

import java.util.Scanner;

import com.itwill.page.item.ProductList;
import com.itwill.page.manager.ManagerMain;
import com.itwill.page.utils.ConsoleClear;
import com.itwill.vo.UserVO;

public class Homepage {
	private static final int product = 1;
	private static final int qna = 2;
	private static final int editProfile = 3; 
	private static final int logout = 4;
	private static final int deleteAccount = 5;
	private static final int manageMode = 6;
	private static final Scanner scan = new Scanner(System.in);
	
	private static UserVO User;
	private static boolean ManagerValidation = false;

	public static void exe(UserVO user) {
		User = user;
		ManagerValidation = checkManager();
		checkManager();
		displayHomeScreen();
		processUserChoice(getUesrChoice());
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
		System.out.println("<> 1.상품 <>\n"
				+ "<> 2.문의 <>\n"
				+ "<> 3.회원정보 수정 <>\n"
				+ "<> 4.로그아웃 <>\n"
				+ "<> 5.회원탈퇴 <>");
		if (ManagerValidation) System.out.println("<> 6. 관리자 메뉴 <>");
		System.out.println("<> 페이지를 종료하려면 'q'를 입력하세요.<>");
	}
	
	private static int getUesrChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return 0;
				int inputRL = Integer.parseInt(input);
				
				if(inputRL == product || inputRL == qna || inputRL == editProfile || inputRL == logout || inputRL == deleteAccount) {
					return inputRL;
				} else if(inputRL == manageMode && ManagerValidation) {
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
			ProductList.exe(User);
		} else if (choice == qna) {
			System.out.println("문의 페이지입니다. 추후 구현");
			// QnA.exe(User);
		} else if (choice == editProfile){
			System.out.println("회원정보 수정 페이지입니다.");
			EditProfile.exe(User);
		} else if (choice == logout) {
			System.out.println("로그아웃에 성공했습니다.");
			System.out.println("메인 페이지입니다.");
			Main.exe();
		} else if (choice == deleteAccount) {
			System.out.println("회원탈퇴 페이지입니다.");
			SignOut.exe(User);
		} else if (choice == 7 && ManagerValidation) {
			System.out.println("관리자 페이지로 이동합니다.");
			ManagerMain.exe(User);
		} else if (choice == 0) {
			System.out.println("페이지를 종료합니다.");
		}
		return;
		
	}
	
	private static boolean checkManager() {
		if(User.getMANAGER().equalsIgnoreCase("TRUE")) return true;
		return false;
	}

}
