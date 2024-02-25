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
	
	public static void RegisteringProduct(UserVO user) {
		// 추후 상의
		String name = UserInputScanner.scanProductName();
		int price = UserInputScanner.scanProductPrice();
		String image = UserInputScanner.scanProductImage();
		
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, name);
		sqlPair.put(2, price + "");
		sqlPair.put(3, image);
		
		ClientRegisteringProduct clientRegisteringProduct = new ClientRegisteringProduct();
		clientRegisteringProduct.start(sqlPair);
		
		printResult(clientRegisteringProduct.getResult());
		ProductManagement.exe(user);		
	}

	public static void ModifiedProductName(UserVO user, ItemVO item) {
		ClientEditProductName clientEditProductName = new ClientEditProductName();
		String modifiedName = UserInputScanner.scanProductName();
		
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, modifiedName);
		sqlPair.put(2, item.getNum() + "");
		
		clientEditProductName.start(sqlPair);
		printResult(clientEditProductName.getResult());
		
		ItemVO updatedItem = getUpdatedItemVO(item);
		ItemManagement.exe(user, updatedItem);
	}
	
	public static void ModifiedProductPrice(UserVO user, ItemVO item) {
		ClientEditProductPrice clientEditProductPrice = new ClientEditProductPrice();
		int modifiedPrice = UserInputScanner.scanProductPrice();
		
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, modifiedPrice + "");
		sqlPair.put(2, item.getNum() + "");
		
		clientEditProductPrice.start(sqlPair);
		printResult(clientEditProductPrice.getResult());
		
		ItemVO updatedItem = getUpdatedItemVO(item);
		ItemManagement.exe(user, updatedItem);
	}
	
	public static void ModifiedProductImage(UserVO user, ItemVO item) {
		ClientEditProductImage clientEditProductImage = new ClientEditProductImage();
		String modifiedImage = UserInputScanner.scanProductImage();
		
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, modifiedImage + "");
		sqlPair.put(2, item.getNum() + "");
		
		clientEditProductImage.start(sqlPair);
		printResult(clientEditProductImage.getResult());
		
		ItemVO updatedItem = getUpdatedItemVO(item);
		ItemManagement.exe(user, updatedItem);
	}
	
	
	public static void DeleteProduct(UserVO user, ItemVO item) {
		HashMap<Integer, String> sqlPair = new HashMap<Integer, String>();
		sqlPair.put(1, item.getNum() + "");
		
		ClientDeleteProduct clientDeleteProduct = new ClientDeleteProduct();
		clientDeleteProduct.start(sqlPair);
		
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
		ItemVO updatedItem = clientGetProductVO.getData();
		return updatedItem;
	}
	
}
