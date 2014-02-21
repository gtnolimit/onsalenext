package com.onsalenext.base.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class DBBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED", updatable=true)
	protected Date upd;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED", updatable=false)
	protected Date cpd;
	@Column(name="USER", updatable=true, length=50)
	protected String user;
	public Date getUpd() {
		return upd;
	}
	public void setUpd(Date upd) {
		this.upd = upd;
	}
	public Date getCpd() {
		return cpd;
	}
	public void setCpd(Date cpd) {
		this.cpd = cpd;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}