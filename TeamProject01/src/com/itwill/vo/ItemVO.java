package com.itwill.vo;

public class ItemVO {
	private int productNo;
	private	String productName;
	private int price;
	private int orderCnt;
	
	public ItemVO() {
		this.productNo = 0;
		this.productName = null;
		this.price = 0;
		this.orderCnt = 0;
	}
	
	public ItemVO(int productNo, String productName, int price, int orderCnt) {
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.orderCnt = orderCnt;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderCnt() {
		return orderCnt;
	}

	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}

	@Override
	public String toString() {
		return "ItemVO [productNo=" + productNo + ", productName=" + productName + ", price=" + price + ", orderCnt="
				+ orderCnt + "]";
	}
	
	
}
