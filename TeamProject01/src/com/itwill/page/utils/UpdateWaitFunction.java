package com.itwill.page.utils;

import com.itwill.socket.client.ClientDeleteProduct;
import com.itwill.socket.client.ClientEditAddress;
import com.itwill.socket.client.ClientEditPassword;
import com.itwill.socket.client.ClientEditProductImage;
import com.itwill.socket.client.ClientEditProductName;
import com.itwill.socket.client.ClientEditProductPrice;
import com.itwill.socket.client.ClientRegisteringProduct;

public class UpdateWaitFunction {
	public static void editPassword(ClientEditPassword clientEditPassword) {
		int i = 0;
		while(clientEditPassword.getResult() == false) {
			i++;
			if (i > 100000) return;
		}
		return;
	}
	
	public static void editAddress(ClientEditAddress clientEditAddress) {
		int i = 0;
		while(clientEditAddress.getResult() == false) {
			i++;
			if (i > 100000) return;
		}
		return;
	}
	
	public static void deleteProduct(ClientDeleteProduct clientDeleteProduct) {
		int i = 0;
		while(clientDeleteProduct.getResult() == false) {
			i++;
			if (i > 100000) return;
		}
		return;
	}
	
	public static void editProductPrice(ClientEditProductPrice clientEditProductPrice) {
		int i = 0;
		while(clientEditProductPrice.getResult() == false) {
			i++;
			if (i > 100000) return;
		}
		return;
	}
	
	public static void editProductName(ClientEditProductName clientEditProductName) {
		int i = 0;
		while(clientEditProductName.getResult() == false) {
			i++;
			if (i > 100000) return;
		}
		return;
	}
	
	public static void editProductImage(ClientEditProductImage clientEditProductImage) {
		int i = 0;
		while(clientEditProductImage.getResult() == false) {
			i++;
			if (i > 100000) return;
		}
		return;
	}
	
	public static void registeringProduct(ClientRegisteringProduct clientRegisteringProduct) {
		int i = 0;
		while(clientRegisteringProduct.getResult() == false) {
			i++;
			if (i > 100000) return;
		}
		return;
	}
}
