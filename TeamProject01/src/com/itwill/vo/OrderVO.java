package com.itwill.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderVO implements Serializable {
    private static final long serialVersionUID = 1L; // 직렬화 버전 관리용
    private int Num;
    private int ProductNum;
    private String CustomerEmail;
    private int Count;
    private Timestamp OrderAT;
    
    public OrderVO() {
    	this.Num = 0;
    	this.ProductNum = 0;
    	this.CustomerEmail = null;
    	this.Count = 0;
    	this.OrderAT = null;
    }
    
    public OrderVO(int Num, int ProductNum, String CustomerEmail, int Count, Timestamp OrderAt) {
    	this.Num = Num;
    	this.ProductNum = ProductNum;
    	this.CustomerEmail = CustomerEmail;
    	this.Count = Count;
    	this.OrderAT = OrderAt;
    }


	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	public int getProductNum() {
		return ProductNum;
	}

	public void setProductNum(int productNum) {
		ProductNum = productNum;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public Timestamp getOrderAT() {
		return OrderAT;
	}

	public void setOrderAT(Timestamp orderAT) {
		OrderAT = orderAT;
	}
	
	@Override
	public String toString() {
		return "OrderVO [Num=" + Num + ", ProductNum=" + ProductNum + ", CustomerEmail=" + CustomerEmail + ", Count="
				+ Count + ", OrderAT=" + OrderAT + "]";
	}
	
}
