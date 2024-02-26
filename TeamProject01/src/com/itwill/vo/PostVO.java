package com.itwill.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class PostVO implements Serializable {
	private static final long serialVersionUID = 1L; // 직렬화 버전 관리용
	private String title;
	private String description;
	private Timestamp createdAt;
	private String eMail;
	
	public PostVO() {
		this.title = null;
		this.description = null;
		this.createdAt = null;
		this.eMail = null;
	}
	
	public PostVO(String title, String description, Timestamp createdAt, String eMail) {
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.eMail = eMail;
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
		return "PostVO [title=" + title + ", description=" + description + ", createdAt=" + createdAt + ", eMail="
				+ eMail + "]";
	}
	
}
