package com.itwill.vo;
import java.sql.Timestamp;

public class UserVO {
	private static final long serialVersionUID = 1L; // 직렬화 버전 관리용
	private String EMAIL;
	private String PASSWORD;
	private String FIRSTNAME;
	private String LASTNAME;
	private String GENDER;
	private String ADDRESS;
	private Timestamp CREATE_AT;
	
	public UserVO() {
		this.EMAIL = null;
		this.PASSWORD = null;
		this.FIRSTNAME = null;
		this.LASTNAME = null;
		this.GENDER = null;
		this.ADDRESS = null;
		this.CREATE_AT = null;
	}
	
	public UserVO(String email, String password, String FirstName,
			String LastName, String Gender, String Address) {
		this.EMAIL = email;
		this.PASSWORD = password;
		this.FIRSTNAME = FirstName;
		this.LASTNAME = LastName;
		this.GENDER = Gender;
		this.ADDRESS = Address;
		this.CREATE_AT = null;
	}
	
	public UserVO(String email, String password, String FirstName,
			String LastName, String Gender, String Address, Timestamp Create_At) {
		this.EMAIL = email;
		this.PASSWORD = password;
		this.FIRSTNAME = FirstName;
		this.LASTNAME = LastName;
		this.GENDER = Gender;
		this.ADDRESS = Address;
		this.CREATE_AT = Create_At;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}

	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	
	public String toString() {
		return "Name = " + FIRSTNAME + " " + LASTNAME + "\n"
				+ "Email = " + EMAIL + "\n"
				+ "Gender = " + GENDER + "\n"
				+ "Address = " + ADDRESS + "\n";
	}

	public Timestamp getCREATE_AT() {
		return CREATE_AT;
	}
	
}
