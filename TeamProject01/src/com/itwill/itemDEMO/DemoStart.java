package com.itwill.itemDEMO;

public class DemoStart {

	public static void main(String[] args) {
		
		ItemCatalogue.exe(SeedData.createUserVO(), SeedData.createItemVO());
	}

}