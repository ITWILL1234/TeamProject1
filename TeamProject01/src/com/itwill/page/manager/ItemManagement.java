package com.itwill.page.manager;

import java.util.Scanner;

import com.itwill.page.user.Homepage;
import com.itwill.page.user.Main;
import com.itwill.page.utils.ConsoleClear;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class ItemManagement {
	private static final int MODIFIED_NAME = 1;
	private static final int MODIFIED_PRICE = 2;
	private static final int MODIFIED_IMAGE = 3;
	private static final int REGISTERING_PRODUCT = 4;
	private static final int DELETE_PRODUCT = 5;
	private static final int BACK_MANAGEMENT_PAGE = 6;
	private static final int HOMEPAGE = 7;
	private static final int LOGOUT = 8;
	private static Scanner scan = new Scanner(System.in);
	private static UserVO User;
	private static ItemVO Item;
	public static void exe(UserVO user, ItemVO item) {
		User = user;
		Item = item;
		
		displayItemPage();
		processManagerChoice(getMangerChoice());
	}
	private static void displayItemPage() {
		
		System.out.println("\n상품의 상세정보입니다.");
		System.out.println();
		System.out.println("상품번호 : " + Item.getNum() + " \n"
						 + "상품이름 : " + Item.Name() + "\n"
						 + "가격 : " + Item.getPrice() + "\n") ;
		System.out.println("\n원하는 메뉴를 입력해주세요.");
		System.out.println("<> 1. 상품 이름 수정 <>"
				+ "\n<> 2. 상품 가격 수정 <>"
				+ "\n<> 3. 상품 이미지 수정 <>"
				+ "\n<> 4. 상품 등록 <>"
				+ "\n<> 5. 상품 삭제 <>"
				+ "\n<> 6. 관리자 메인 페이지로 이동"
				+ "\n<> 7. 홈페이지로 이동 <>"
				+ "\n<> 8. 로그아웃 <>");

		System.out.println("페이지를 종료하려면 'q'를 입력해주세요.");
	}
	private static int getMangerChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return 0;
				int inputRL = Integer.parseInt(input);
				
				if (inputRL == MODIFIED_NAME || inputRL == MODIFIED_PRICE || inputRL == MODIFIED_IMAGE || inputRL == REGISTERING_PRODUCT 
						|| inputRL == BACK_MANAGEMENT_PAGE || inputRL == DELETE_PRODUCT || inputRL == LOGOUT || inputRL == HOMEPAGE) {
					return inputRL;
				} else {
					System.out.println("\n1 또는 2를 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("\n숫자로 입력해주세요.");
			}
		}
	}
	
	private static void processManagerChoice(int managerChoice) {
		ConsoleClear.clear();
		
		if (managerChoice == MODIFIED_NAME) {
			// 해당 요청 처리
		} else if (managerChoice == MODIFIED_PRICE) {
			// 해당 요청 처리
		} else if (managerChoice == MODIFIED_IMAGE) {
			// 해당 요청 처리
		} else if (managerChoice == REGISTERING_PRODUCT) {
			// 해당 요청 처리
		} else if (managerChoice == DELETE_PRODUCT) {
			// 해당 요청 처리
		} else if (managerChoice == BACK_MANAGEMENT_PAGE) {
			ManagerMain.exe(User);
		} else if (managerChoice == HOMEPAGE) {
			Homepage.exe(User);
		} else if (managerChoice == LOGOUT) {
			Main.exe();
		} else if (managerChoice == 0) {
			System.out.println("페이지를 종료합니다.");
		}
		return;
	}
	
}
