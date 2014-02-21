package com.onsalenext.base.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.lookup.StateTypeLookup;
import com.onsalenext.base.domain.menu.Category;

@Entity
@Table(name = "STORE", schema="ONSALENEXT_HOME")
public class Store extends DBBase implements Serializable{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name="STORE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (name = "STORE_NAME", unique=false, nullable=false, length=250)
	private String storeName;
	
	@Column (name = "CERTIFICATE", unique=false, nullable=true, length=250)
	private String certificate;
	@Column(name="SMTP_USER", unique=false, nullable=false, length=50)
	private String smtpUser;
	@OneToOne
	@JoinColumn (name="HOME_STATE")
	private StateTypeLookup homeState;
	@Column(name="SMTP_PASS", unique=false, nullable=false, length=50)
	private String smtpPass;
	@Column(name="INFO_EMAIL", unique=false, nullable=false, length=50)
	private String infoEmail;
	@Column(name="SMTP_HOST", unique=false, nullable=false, length=50)
	private String smtpHost;
	@Column(name="SMTP_PORT", unique=false, nullable=false, length=50)
	private String smtpPort;
	@Column(name = "STATUS", unique=false, nullable=false)
	private boolean isActive;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Ip ip;
	
	@OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="STORE_CATEGORY_LINK", 
                joinColumns={@JoinColumn(name="STORE_ID")}, 
                inverseJoinColumns={@JoinColumn(name="CATEGORY_ID")})
    private Set<Category> categories = new HashSet<Category>();

	public Store () {}

	public Store (Long id, String storeName, Ip ip, String certificate, String smtpUser, StateTypeLookup homeState, 
			String smtpPass, String infoEmail, String smtpHost, String smtpPort, boolean isActive, 
			Set<Category> categories, Date upd, String user){
		this.id = id;
		this.storeName	  = storeName;
		this.ip	  = ip;
		this.certificate  = certificate;
		this.smtpUser	  = smtpUser;
		this.homeState	  = homeState;
		this.smtpPass	  = smtpPass;
		this.infoEmail	  = infoEmail;
		this.smtpHost	  = smtpHost;
		this.smtpPort	  = smtpPort;
		this.categories = categories;
		this.isActive = isActive;
		this.upd = upd;
		this.user = user;
	}	
	
	public Store (Long id, String storeName, Ip ip, String certificate, String smtpUser, StateTypeLookup homeState, 
			String smtpPass, String infoEmail, String smtpHost, String smtpPort, boolean isActive, 
			Set<Category> categories, Date cpd, Date upd, String user){
		this.id = id;
		this.storeName	  = storeName;
		this.ip	  = ip;
		this.certificate  = certificate;
		this.smtpUser	  = smtpUser;
		this.homeState	  = homeState;
		this.smtpPass	  = smtpPass;
		this.infoEmail	  = infoEmail;
		this.smtpHost	  = smtpHost;
		this.smtpPort	  = smtpPort;
		this.categories = categories;
		this.isActive = isActive;
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Ip getIp() {
		return ip;
	}

	public void setIp(Ip ip) {
		this.ip = ip;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public String getSmtpUser() {
		return smtpUser;
	}

	public void setSmtpUser(String smtpUser) {
		this.smtpUser = smtpUser;
	}

	public String getSmtpPass() {
		return smtpPass;
	}

	public void setSmtpPass(String smtpPass) {
		this.smtpPass = smtpPass;
	}

	public String getInfoEmail() {
		return infoEmail;
	}

	public void setInfoEmail(String infoEmail) {
		this.infoEmail = infoEmail;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public StateTypeLookup getHomeState() {
		return homeState;
	}

	public void setHomeState(StateTypeLookup homeState) {
		this.homeState = homeState;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
