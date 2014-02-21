package com.onsalenext.base.web.model.person;

public class UserInfoBom implements Comparable<UserInfoBom>{

	private Long id; 
	private String email;
	private String password;
	
	public UserInfoBom ( Long id, String email, String password ) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int compareTo(UserInfoBom o) {
		return email.compareTo(o.email);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
