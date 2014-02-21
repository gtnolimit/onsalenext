package com.onsalenext.base.domain.person;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "USER_INFO", schema="ONSALENEXT_CUSTOMER")
public class UserInfo extends DBBase implements Serializable{
	
	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "EMAIL", unique=true, nullable=false, length=50)
	private String email;
	
	@Column(name = "PASSWORD", unique=true, nullable=false, length=15)
	private String password;
	
	public UserInfo () {}
	
	public UserInfo ( Long id, String email, String password, Date upd, String user){
		this.id = id;
		this.email = email;
		this.password = password;
		this.upd = upd;
		this.user = user;
	}
	
	public UserInfo ( Long id, String email, String password, Date cpd, Date upd, String user){
		this.id = id;
		this.email = email;
		this.password = password;
		this.cpd = cpd;
		this.upd = upd;
		this.user = user;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
