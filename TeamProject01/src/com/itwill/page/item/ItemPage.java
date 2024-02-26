package com.itwill.page.item;

import java.util.Scanner;

import com.itwill.page.utils.ConsoleClear;
import com.itwill.page.utils.PrintImage;
import com.itwill.socket.client.ClientCheckOrderHistory;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class ItemPage {
	private static final int BUY = 1;
	private static final int REVIEW = 2;
	private static final int BACK = 3;
	private static final int WRITE_REVIEW = 4;
	private static Scanner scan = new Scanner(System.in);
	private static UserVO User;
	private static ItemVO Item;
	private static boolean PurchaseHistory;
	public static void exe(UserVO user, ItemVO item) {
		User = user;
		Item = item;
		PurchaseHistory = checkPurchaseHistory();
		
		
		displayItemPage();
		int inputRL = getUserChoice();
		processUserChoice(inputRL);
		
	}
	private static void displayItemPage() {
		
		System.out.println("\n상품의 상세정보입니다.");
		System.out.println();
		PrintImage.exe(Item.getImage());
		System.out.println(Item.getImage());
		System.out.println("상품번호 : " + Item.getNum() + " \n"
						 + "상품이름 : " + Item.Name() + "\n"
						 + "가격 : " + Item.getPrice() + "\n") ;
		System.out.println("\n원하는 메뉴를 입력해주세요.");
		System.out.println("<> 1. 상품구매 <>"
				+ "\n<> 2. 리뷰보기 <> "
				+ "\n<> 3. 뒤로가기 <>");
		if (PurchaseHistory) System.out.println("<> 4. 리뷰 작성하기 <>");
		System.out.println("페이지를 종료하려면 'q'를 입력해주세요.");
		
	}
	
	private static int getUserChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return 0;
				int inputRL = Integer.parseInt(input);
				
				if (inputRL == BUY || inputRL == REVIEW || inputRL == BACK) {
					return inputRL;
				} else {
					System.out.println("\n1 또는 2를 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("\n숫자로 입력해주세요.");
			}
		}
		
	}
	
	private static void processUserChoice(int choice) {
		ConsoleClear.clear();
		
		if (choice == BUY) {
			OrderPage.exe(User, Item);
		} else if (choice == REVIEW) {
			ConsoleClear.clear();
			System.out.println("리뷰 페이지입니다.");
			Post.exe(User, Item.getNum());
	 	} else if (choice == BACK) {
			System.out.println("상품 페이지입니다.");
			ProductList.exe(User);
		} else if (choice == WRITE_REVIEW) {
			System.out.println("리뷰 작성 페이지입니다.");
			Review.exe(User, Item);
		} else if (choice == 0) {
			System.out.println("페이지를 종료합니다.");
			return;
		}
	}
	
	private static boolean checkPurchaseHistory() {
		ClientCheckOrderHistory clientCheckOrderHistory = new ClientCheckOrderHistory();
		clientCheckOrderHistory.start(User.getEMAIL(), Item.getNum());
		return clientCheckOrderHistory.getResult();
	}
	
}
