package com.onsalenext.base.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "IP", schema="ONSALENEXT_HOME")
public class Ip extends DBBase implements Serializable{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name="IP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	@Column(name = "IP", unique=false, nullable=false, length=30)
	private String ip;
	@Column (name = "SESSION", unique=false, nullable=true, length=200)
	private String session;

	public Ip () {}
	
	public Ip ( Long id, String ip, String session, Date upd, String user){
		this.id = id; 
		this.ip = ip; 
		this.session = session;
		this.upd = upd;
		this.user = user;
	}

	public Ip ( Long id, String ip, String session, Date cpd, Date upd, String user){
		this.id = id; 
		this.ip = ip; 
		this.session = session;
		this.cpd = cpd;
		this.upd = upd;
		this.user = user;
	}
	
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
