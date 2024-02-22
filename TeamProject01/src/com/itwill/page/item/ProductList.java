package com.itwill.page.item;

import java.util.ArrayList;
import java.util.Scanner;

import com.itwill.crud.ProductDAO;
import com.itwill.page.user.ConsoleClear;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class ProductList {
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<ItemVO> Item;
	private static UserVO User;
	
	public static void exe(UserVO user) {
		User = user;
		Item = ProductDAO.getProductList();
		
		displayItemScreen();
		productMenu();
		getUeserChoice();
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
		System.out.println(" 구매하실 상품번호를 입력해주세요.");
//		for (ItemVO vo : Item) {
//			System.out.println(vo.getNum() + ". " + vo.getPrice());
//		}
	}
	
	private static void getUeserChoice() {
		while (true) {
			try {
				System.out.println("getUeserChoice() 실행");
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return;
				int inputRL = Integer.parseInt(input);
				
				processUserChoice(Item.get(inputRL - 1));
				
			} catch (NumberFormatException e) {
				System.out.println("\n숫자 또는 Q 를 입력해주세요.");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("\n존재하지 않는 상품번호입니다.");
			}
			
		}
		
	} 
	
	private static void productMenu() {
	    for (ItemVO product : Item) {
	        System.out.println("상품번호: " + product.getNum() + ", 상품명: " + product.Name() + ", 가격: " + product.getPrice());
	    }
	}

	private static void processUserChoice(ItemVO choice) {
		ConsoleClear.clear();
		System.out.println("상품페이지로 이동합니다.");
		ItemPage.exe(User, choice);
		
	}
	
}
