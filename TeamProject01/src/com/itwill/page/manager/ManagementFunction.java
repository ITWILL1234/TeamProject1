package com.itwill.page.manager;

import java.util.HashMap;

import com.itwill.page.utils.ConsoleClear;
import com.itwill.socket.client.ClientDeleteProduct;
import com.itwill.socket.client.ClientEditProductImage;
import com.itwill.socket.client.ClientEditProductName;
import com.itwill.socket.client.ClientEditProductPrice;
import com.itwill.socket.client.ClientGetProductVO;
import com.itwill.socket.client.ClientRegisteringProduct;
import com.itwill.utils.UserInputScanner;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class ManagementFunction {
	private static int waitTime = 1000000;
	public static void RegisteringProduct(UserVO user) {
		String name = UserInputScanner.scanProductName();
		int price = UserInputScanner.scanProductPrice();
		String image = UserInputScanner.scanProductImage();
		
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, name);
		sqlPair.put(2, price + "");
		sqlPair.put(3, image);
		
		ClientRegisteringProduct clientRegisteringProduct = new ClientRegisteringProduct();
		clientRegisteringProduct.start(sqlPair);
		waitRegisteringProduct(clientRegisteringProduct);
		waitSecond();
		printResult(clientRegisteringProduct.getResult());
		
		System.out.println("실행이 되어야 한다...");
		ProductManagement.exe(user);		
	}

	public static void ModifiedProductName(UserVO user, ItemVO item) {
		ClientEditProductName clientEditProductName = new ClientEditProductName();
		String modifiedName = UserInputScanner.scanProductName();
		
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, modifiedName);
		sqlPair.put(2, item.getNum() + "");
		
		clientEditProductName.start(sqlPair);
		waitEditProductName(clientEditProductName);
		waitSecond();
		printResult(clientEditProductName.getResult());
		
		ItemVO updatedItem = getUpdatedItemVO(item);
		
		System.out.println("실행이 되어야 한다...");
		ItemManagement.exe(user, updatedItem);
	}
	
	public static void ModifiedProductPrice(UserVO user, ItemVO item) {
		ClientEditProductPrice clientEditProductPrice = new ClientEditProductPrice();
		int modifiedPrice = UserInputScanner.scanProductPrice();
		
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, modifiedPrice + "");
		sqlPair.put(2, item.getNum() + "");
		
		clientEditProductPrice.start(sqlPair);
		waitEditProductPrice(clientEditProductPrice);
		waitSecond();
		printResult(clientEditProductPrice.getResult());
		
		ItemVO updatedItem = getUpdatedItemVO(item);
		
		System.out.println("실행이 되어야 한다...");
		ItemManagement.exe(user, updatedItem);
	}
	
	public static void ModifiedProductImage(UserVO user, ItemVO item) {
		ClientEditProductImage clientEditProductImage = new ClientEditProductImage();
		String modifiedImage = UserInputScanner.scanProductImage();
		
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, modifiedImage + "");
		sqlPair.put(2, item.getNum() + "");
		
		clientEditProductImage.start(sqlPair);
		waitEditProductImage(clientEditProductImage);
		waitSecond();
		printResult(clientEditProductImage.getResult());
		
		ItemVO updatedItem = getUpdatedItemVO(item);
		ItemManagement.exe(user, updatedItem);
	}
	
	
	public static void DeleteProduct(UserVO user, ItemVO item) {
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, item.getNum() + "");
		
		ClientDeleteProduct clientDeleteProduct = new ClientDeleteProduct();
		clientDeleteProduct.start(sqlPair);
		waitDeleteProduct(clientDeleteProduct);
		waitSecond();
		printResult(clientDeleteProduct.getResult());
		
		ProductManagement.exe(user);
	}
	
	private static void printResult(boolean exeResult) {
		ConsoleClear.clear();
		if (exeResult) {
			System.out.println("데이터가 성공적으로 수정되었습니다!");
		} else {
			System.out.println("데이터 업데이트에 실패하였습니다!");
		}
	}
	
	private static ItemVO getUpdatedItemVO(ItemVO item) {
		ClientGetProductVO clientGetProductVO = new ClientGetProductVO();
		clientGetProductVO.start(item.getNum());
		waitGetUpdatedItemVO(clientGetProductVO);
		waitSecond();
		ItemVO updatedItem = clientGetProductVO.getData();
		return updatedItem;
	}
	
	private static void waitGetUpdatedItemVO(ClientGetProductVO clientGetProductVO) {
		int i = 0;
		while(clientGetProductVO.getData() == null) {
			i++;
			if (i > waitTime) return;
		}
		return;
	}
	
	private static void waitDeleteProduct(ClientDeleteProduct clientDeleteProduct) {
		int i = 0;
		while(clientDeleteProduct.getResult() == false) {
			i++;
			if (i > waitTime) return;
		}
		return;
	}
	
	private static void waitEditProductPrice(ClientEditProductPrice clientEditProductPrice) {
		int i = 0;
		while(clientEditProductPrice.getResult() == false) {
			i++;
			if (i > waitTime) return;
		}
		return;
	}
	
	private static void waitEditProductName(ClientEditProductName clientEditProductName) {
		int i = 0;
		while(clientEditProductName.getResult() == false) {
			i++;
			if (i > waitTime) return;
		}
		return;
	}
	
	private static void waitEditProductImage(ClientEditProductImage clientEditProductImage) {
		int i = 0;
		while(clientEditProductImage.getResult() == false) {
			i++;
			if (i > waitTime) return;
		}
		return;
	}
	
	private static void waitRegisteringProduct(ClientRegisteringProduct clientRegisteringProduct) {
		int i = 0;
		while(clientRegisteringProduct.getResult() == false) {
			i++;
			if (i > waitTime) return;
		}
		return;
	}
	
	private static void waitSecond() {
		int i = 0;
		while (i < waitTime) {
			i++;
		}
		return;
	}
	
}
