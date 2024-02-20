package com.itwill.user.vo;

public class UserVO {
	private String EMAIL;
	private String PASSWORD;
	private String USERNAME;
	private String FIRSTNAME;
	private String LASTNAME;
	private String GENDER;
	private String ADDRESS;
	
	public UserVO() {
		this.EMAIL = null;
		this.PASSWORD = null;
		this.USERNAME = null;
		this.FIRSTNAME = null;
		this.LASTNAME = null;
		this.GENDER = null;
		this.ADDRESS = null;
	}
	
	public UserVO(String email, String password, String UserName, String FirstName,
			String LastName, String Gender, String Address) {
		this.EMAIL = email;
		this.PASSWORD = password;
		this.USERNAME = UserName;
		this.FIRSTNAME = FirstName;
		this.LASTNAME = LastName;
		this.GENDER = Gender;
		this.ADDRESS = Address;
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

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
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
		return "Name = " + FIRSTNAME + LASTNAME + "\n"
				+ "Email = " + EMAIL + "\n"
				+ "UserName = " + USERNAME + "\n"
				+ "Gender = " + GENDER + "\n"
				+ "Address = " + ADDRESS + "\n";
	}
	
}
