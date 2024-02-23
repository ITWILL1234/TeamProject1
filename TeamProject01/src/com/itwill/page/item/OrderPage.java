package com.itwill.page.item;

import java.util.HashMap;

import com.itwill.crud.CUD;
import com.itwill.utils.UserInputScanner;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class OrderPage {
	private static final String SQL = "INSERT INTO ORDER (EMAIL, ADDRESS, ITEMNUM, ITEMNAME"
			+ ", ITEMCOUNT, TOT ) VALUES (?, ?, ?, ?, ?, ?) ";
	private static UserVO User;
	private static ItemVO Item;
	private static int count = UserInputScanner.scanNumber();
	private static int tot = (Item.getPrice() * count);
	private static HashMap<Integer, String> Pair = new HashMap<Integer, String>();
	
	
	public static void exe(UserVO user, ItemVO item) {
		User = user;
		Item = item;
		
		displayOrderPage();
		
	}


	private static void displayOrderPage() {
		
		System.out.println("주문 페이지입니다.");
		System.out.println("상품을 확인해주세요.");
		System.out.println(Item.getNum() + ". " + Item.Name());
		System.out.println("상품금액 : " + Item.getPrice());
		System.out.println("주문수량 : " + count);
		System.out.println("결제금액 : " + tot);
		
		System.out.println("\n결제를 완료하였습니다.");
		System.out.println("3초 뒤 상품목록 페이지로 이동합니다.");
		
		CUD.exeItem(SQL, null);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ProductList.exe(User);
		
	}
	//"INSERT INTO ORDER (EMAIL, ADDRESS, ITEMNUM, ITEMNAME"
	//+ ", ITEMCOUNT, TOT ) VALUES (?, ?, ?, ?, ?, ?) ";
	private static HashMap<Integer, String> createSqlPair() {
		Pair.put(1, User.getEMAIL());
		Pair.put(2, User.getADDRESS());
		Pair.put(3, Integer.toString(Item.getNum()));
		Pair.put(4, Item.Name());
		Pair.put(5, Integer.toString(count));
		Pair.put(6, Integer.toString(tot));
		return Pair;
	}
	
	
}
