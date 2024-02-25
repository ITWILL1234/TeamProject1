package com.itwill.page.item;

import java.util.HashMap;

import com.itwill.page.utils.PrintImage;
import com.itwill.socket.client.ClientOrder;
import com.itwill.utils.UserInputScanner;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class OrderPage {
	private static UserVO User;
	private static ItemVO Item;
	private static int count;
	
	public static void exe(UserVO user, ItemVO item) {
		User = user;
		Item = item;
		
		orderPage();
		proceedInsertOracle();
	}


	private static void orderPage() {
		
		System.out.println("주문 페이지입니다.");
		System.out.println("상품을 확인해주세요.");
		System.out.println(Item.getNum() + ". " + Item.Name());
		System.out.println("상품금액 : " + Item.getPrice());
		
		count = UserInputScanner.scanNumber();
		
		System.out.println("주문수량 : " + count);
		System.out.println("결제금액 : " + (Item.getPrice() * count));
		
	}
	
	private static void proceedInsertOracle() {
		ClientOrder clientOrder = new ClientOrder();
		clientOrder.start(createSqlPair());
		if (clientOrder.getResult()) {
			successPayment();
		} else {
			failPayment();
		}
		ProductList.exe(User);
	}
	
	private static HashMap<Integer, String>createSqlPair() {
		HashMap<Integer, String> pair = new HashMap<Integer, String>();
		pair.put(1, Item.getNum() + "");
		pair.put(2, User.getEMAIL());
		pair.put(3, User.getADDRESS());
		pair.put(4, count + "");
		pair.put(5, (Item.getPrice() * count) + "");
		return pair;
	}
	
	private static void successPayment() {
		PrintImage.printBitCoin();
		System.out.println("\n결제를 완료하였습니다.");
		System.out.println("3초 뒤 상품목록 페이지로 이동합니다.");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void failPayment() {
		System.out.println("알 수 없는 이유로 결제에 실패하였습니다.");
		System.out.println("3초 뒤 상품목록 페이지로 이동합니다.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
