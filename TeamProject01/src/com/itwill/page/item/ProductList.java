package com.itwill.page.item;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.itwill.page.user.Homepage;
import com.itwill.page.user.Main;
import com.itwill.page.utils.ConsoleClear;
import com.itwill.socket.client.ClientProductList;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class ProductList {
	private static Scanner scan = new Scanner(System.in);
	private static HashMap<Integer, ItemVO> Item;
	private static UserVO User;
	
	public static void exe(UserVO user) {
		ClientProductList clientProductList = new ClientProductList();
		clientProductList.start();
		User = user;
		Item = clientProductList.getData();
		
		displayItemScreen();
		productMenu();
		getUserChoice();
		return;
	}

	private static void displayItemScreen() {
		System.out.println("\r\n"
				+ " ██████╗ █████╗ ████████╗ █████╗ ██╗      ██████╗  ██████╗ ██╗   ██╗███████╗\r\n"
				+ "██╔════╝██╔══██╗╚══██╔══╝██╔══██╗██║     ██╔═══██╗██╔════╝ ██║   ██║██╔════╝\r\n"
				+ "██║     ███████║   ██║   ███████║██║     ██║   ██║██║  ███╗██║   ██║█████╗  \r\n"
				+ "██║     ██╔══██║   ██║   ██╔══██║██║     ██║   ██║██║   ██║██║   ██║██╔══╝  \r\n"
				+ "╚██████╗██║  ██║   ██║   ██║  ██║███████╗╚██████╔╝╚██████╔╝╚██████╔╝███████╗\r\n"
				+ " ╚═════╝╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝╚══════╝ ╚═════╝  ╚═════╝  ╚═════╝ ╚══════╝\r\n"
				+ "                                                                            \r\n"
				+ ""
				);
		System.out.println("구매하실 상품번호를 입력해주세요.");
	}
	
	private static void getUserChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return;
				else if (input.equalsIgnoreCase("H")) {
					ConsoleClear.clear();
					Homepage.exe(User);
					return;
				}
				else if (input.equalsIgnoreCase("L")) {
					Main.exe(); 
					return;
				}
				
				int inputRL = Integer.parseInt(input);
				
				ItemVO selectItem = Item.get(inputRL);
				if (selectItem != null) processUserChoice(selectItem);
				
			} catch (NumberFormatException e) {
				System.out.println("\n상품번호 또는 q 를 입력해주세요.");
			}
		}
		
	} 
	
	private static void productMenu() {
	    for (Map.Entry<Integer, ItemVO> entry : Item.entrySet()) {
	        System.out.println("상품번호: " + entry.getValue().getNum() + ", 상품명: " + entry.getValue().Name() + ", 가격: " + entry.getValue().getPrice());
	    }
	    System.out.println();
	    System.out.println("<> 홈페이지로 돌아가려면 H를 입력해주세요. <>");
	    System.out.println("<> 로그아웃을 하려면 L을 입력해주새요. <>");
	    System.out.println("<> 종료하려면 Q를 입력해주세요. <>");
	}

	private static void processUserChoice(ItemVO choice) {
		ConsoleClear.clear();
		System.out.println("상품 페이지로 이동합니다.");
		ItemPage.exe(User, choice);
		
	}
	
}
