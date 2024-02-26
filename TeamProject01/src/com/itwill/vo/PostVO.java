package com.itwill.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class PostVO implements Serializable {
	private static final long serialVersionUID = 1L; // 직렬화 버전 관리용
	private int num;
	private String title;
	private String description;
	private Timestamp createdAt;
	private String eMail;
	
	public PostVO() {
		this.num = 0;
		this.title = null;
		this.description = null;
		this.createdAt = null;
		this.eMail = null;
	}
	
	public PostVO(int num, String title, String description, Timestamp createdAt, String eMail) {
		this.num = num;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.eMail = eMail;
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getEMail() {
		return eMail;
	}

	public void setAuthor(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "PostVO [num=" + num + ", title=" + title + ", description=" + description + ", createdAt=" + createdAt
				+ ", eMail=" + eMail + "]";
	}

	
}
