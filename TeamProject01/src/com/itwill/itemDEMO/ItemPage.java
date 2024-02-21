package com.itwill.itemDEMO;

import java.util.Scanner;

import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class ItemPage {
	private static final int BUY = 1;
	private static final int CATALOGUE = 2;
	private static Scanner scan = new Scanner(System.in);
	private static UserVO User;
	private static ItemVO Item;
	public static void exe(UserVO user, ItemVO item) {
		User = user;
		Item = item;
		System.out.println(User);
		System.out.println(Item);
		
		displayItemPage();
		int inputRL = getUserChoice();
		processUserChoice(inputRL);
		
	}
	private static void displayItemPage() {
		
		System.out.println("상품의 상세정보입니다.");
		System.out.println();
		System.out.println("상품번호 : " + Item.getProductNo() + ". \n"
						 + "상품이름 : " + Item.getProductName() + "\n"
						 + "가격 : " + Item.getPrice() + "\n" 
						 + "수량 : " + Item.getOrderCnt());
		
		System.out.println("원하는 메뉴를 입력하세요.");
		System.out.println("1. 상품구매 2. 카탈로그");
		
	}
	
	private static int getUserChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				int inputRL = Integer.parseInt(input);
				
				if (inputRL == BUY || inputRL == CATALOGUE) {
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
		
		if (choice == CATALOGUE) {
			ItemCatalogue.exe(User, null);
		}
			
	}
	
}
