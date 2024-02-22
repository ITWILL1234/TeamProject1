package com.itwill.page.item;

import java.util.Scanner;

import com.itwill.page.ConsoleClear;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class ItemPage {
	private static final int BUY = 1;
	private static final int BACK = 2;
	private static Scanner scan = new Scanner(System.in);
	private static UserVO User;
	private static ItemVO Item;
	public static void exe(UserVO user, ItemVO item) {
		User = user;
		Item = item;
		
		displayItemPage();
		int inputRL = getUserChoice();
		processUserChoice(inputRL);
		
	}
	private static void displayItemPage() {
		
		System.out.println("\n상품의 상세정보입니다.");
		System.out.println();
<<<<<<< HEAD:TeamProject01/src/com/itwill/page/item/ItemPage.java
		System.out.println("상품번호 : " + Item.getNum() + " \n"
						 + "상품이름 : " + Item.Name() + "\n"
						 + "가격 : " + Item.getPrice() + "\n") ;
=======
		System.out.println("상품번호 : " + Item.getProductNo() + "\n"
						 + "상품이름 : " + Item.getProductName() + "\n"
						 + "가격 : " + Item.getPrice() + "\n");
>>>>>>> origin/Item:TeamProject01/src/com/itwill/itemDEMO/ItemPage.java
		
		System.out.println("\n원하는 메뉴를 입력해주세요.");
		System.out.println("1. 상품구매 2. 뒤로가기");
		System.out.println("페이지를 종료하려면 'q'를 입력해주세요.");
		
	}
	
	private static int getUserChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return 0;
				int inputRL = Integer.parseInt(input);
				
				if (inputRL == BUY || inputRL == BACK) {
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
		
<<<<<<< HEAD:TeamProject01/src/com/itwill/page/item/ItemPage.java
		if (choice == CATALOGUE) {
			ProductList.exe(User);
=======
		if (choice == BUY) {
			OrderPage.exe(User, Item);
>>>>>>> origin/Item:TeamProject01/src/com/itwill/itemDEMO/ItemPage.java
		}
		if (choice == BACK) {
			System.out.println("상품 페이지입니다.");
			ItemCatalogue.exe(User, null);
		} else if (choice == 0) {
			System.out.println("페이지를 종료합니다.");
		}
		return;
	}
	
}
