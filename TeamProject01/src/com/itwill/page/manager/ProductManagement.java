package com.itwill.page.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.itwill.page.user.Homepage;
import com.itwill.page.utils.ConsoleClear;
import com.itwill.socket.client.ClientProductList;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class ProductManagement {
	private static Scanner scan = new Scanner(System.in);
	private static HashMap<Integer, ItemVO> Item;
	private static UserVO User;
	public static void exe(UserVO user) {
		ClientProductList clientProductList = new ClientProductList();
		clientProductList.start();
		User = user;
		Item = clientProductList.getData();
		
		displayScreen();
		productMenu();
		getManagerChoice();
	}
	
	private static void displayScreen() {
		System.out.println(""
				+ "\n"
				+ "██████╗ ██████╗  ██████╗ ██████╗ ██╗   ██╗ ██████╗████████╗     ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗███╗   ███╗███████╗███╗   ██╗████████╗\n"
				+ "██╔══██╗██╔══██╗██╔═══██╗██╔══██╗██║   ██║██╔════╝╚══██╔══╝     ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝████╗ ████║██╔════╝████╗  ██║╚══██╔══╝\n"
				+ "██████╔╝██████╔╝██║   ██║██║  ██║██║   ██║██║        ██║        ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██╔████╔██║█████╗  ██╔██╗ ██║   ██║   \n"
				+ "██╔═══╝ ██╔══██╗██║   ██║██║  ██║██║   ██║██║        ██║        ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║   ██║   \n"
				+ "██║     ██║  ██║╚██████╔╝██████╔╝╚██████╔╝╚██████╗   ██║███████╗██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║ ╚═╝ ██║███████╗██║ ╚████║   ██║   \n"
				+ "╚═╝     ╚═╝  ╚═╝ ╚═════╝ ╚═════╝  ╚═════╝  ╚═════╝   ╚═╝╚══════╝╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   \n"
				+ "                                                                                                                                                            \n"
				+ "");
		System.out.println("관리할 상품 번호를 선택해주세요.");
	}
	
	private static void getManagerChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return;
				if (input.equalsIgnoreCase("H")) Homepage.exe(User);
				int inputRL = Integer.parseInt(input);
				
				// 상품 등록으로 이동
				if (inputRL == 0) ManagementFunction.RegisteringProduct(User);
				
				// 해당 값에 맞는 페이지를 찾아감.
				ItemVO selectItem = Item.get(inputRL);
				if (selectItem != null) processManagerChoice(selectItem);
				else if (selectItem == null) {
					System.out.println(">> 입력한 번호에 해당하는 상품이 존재하지 않습니다. <<");
					getManagerChoice();
				}
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
	    System.out.println("상품을 추가하시려면 0을 눌러주세요.");
	    System.out.println("종료하려면 q를 입력해주세요.");
	    System.out.println("홈으로 돌아가려면 h를 입력해주세요.");
	}
	
	private static void processManagerChoice(ItemVO choice) {
		ConsoleClear.clear();
		System.out.println("상품 페이지로 이동합니다.");
		ItemManagement.exe(User, choice);
	}
	
}
