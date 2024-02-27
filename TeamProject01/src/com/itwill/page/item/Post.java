package com.itwill.page.item;

import java.util.ArrayList;
import java.util.Scanner;

import com.itwill.page.utils.ConsoleClear;
import com.itwill.socket.client.ClientGetReviews;
import com.itwill.vo.ItemVO;
import com.itwill.vo.PostVO;
import com.itwill.vo.UserVO;

public class Post {
	private static final int ITEM = 1;
	private static Scanner scan = new Scanner(System.in);
	private static UserVO User;
	private static int ItemNum;
	private static ItemVO Item;
	
	
	public static void exe(UserVO user, ItemVO item) {
		ItemNum = 0;
		User = user;
		ItemNum = item.getNum();
		Item = item;
		ClientGetReviews clientGetReviews = new ClientGetReviews();
		clientGetReviews.start(ItemNum);
		waitSecond();
		displayScreen(clientGetReviews.getData());

		processUserChoice(getUserChoice());
	
	}
	
	private static void displayScreen(ArrayList<PostVO> list) {
		System.out.println("\n * 사용자들의 리뷰 *");
		for(PostVO review : list) {
			System.out.println("제목 : " + review.getTitle());
			System.out.println("작성자 : " + review.getEMail());
			System.out.println("본문 : " + review.getDescription());
			System.out.println("작성일 : " + review.getCreatedAt());
			System.out.println();
		}
		
		System.out.println("<> 1. 상품창으로 돌아가기 <>"
				+ "\n<> Q. 종료 <>");
	}
	
	private static void waitSecond() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int getUserChoice() {
		while (true) {
			try {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Q")) return 0;
				int inputRL = Integer.parseInt(input);
				
				if (inputRL == ITEM) {
					return inputRL;
				} else {
					System.out.println("\n입력값이 유효하지 않습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("\n숫자혹은 Q를 입력해주세요.");
			}
		}
		
	}
	
	private static void processUserChoice(int choice) {
		ConsoleClear.clear();
		
		if (choice == 0) {
			System.out.println("종료합니다.");
			return;
		} else if (choice == ITEM) {
			ConsoleClear.clear();
			System.out.println("아이템창으로 돌아갑니다.");
			ItemPage.exe(User, Item);
		}
	}
	
}
