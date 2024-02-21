package com.itwill.itemDEMO;

import java.util.ArrayList;
import java.util.Scanner;

import com.itwill.page.ConsoleClear;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class ItemCatalogue {
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<ItemVO> Item;
	private static UserVO User;
	
	public static void exe(UserVO user, ArrayList<ItemVO> item) {
		User = user;
		Item = item;
		
		displayItemScreen();
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
		System.out.println("상품번호를 입력해주세요.");
		for (ItemVO vo : Item) {
			System.out.println(vo.getProductNo() + ". " + vo.getProductName());
		}
	}
	
	private static void getUeserChoice() {
		while (true) {
			try {
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
	
	private static void processUserChoice(ItemVO choice) {
		ConsoleClear erase = new ConsoleClear();
		erase.clear();
		System.out.println("상품페이지로 이동합니다.");
		ItemPage.exe(User, choice);
		
	}
	
}
