package com.onsalenext.base.web.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.onsalenext.base.domain.lookup.StateTypeLookup;
import com.onsalenext.base.web.model.menu.CategoryBom;

@XmlRootElement(name = "store")
public class StoreBom  implements Comparable<StoreBom>{
	private Long id;
	private String storeName;
	private String certificate;
	private String smtpUser;
	private StateTypeLookup homeState;
	private String smtpPass;
	private String infoEmail;
	private String smtpHost;
	private String smtpPort;
	private boolean isActive;
	private Set<CategoryBom> categories;
	private IpBom ip;

	public StoreBom ( Long id, String storeName, IpBom ip, String certificate, String smtpUser, StateTypeLookup homeState, 
			String smtpPass, String infoEmail, String smtpHost, String smtpPort, boolean isActive, 
			Set<CategoryBom> categories){
		this.id = id;
		this.storeName = storeName;
		this.certificate = certificate;
		this.smtpUser = smtpUser;
		this.homeState = homeState;
		this.smtpPass = smtpPass;
		this.infoEmail = infoEmail;
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
		this.isActive = isActive;
		this.ip = ip;
		this.categories = categories;
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

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getSmtpUser() {
		return smtpUser;
	}

	public void setSmtpUser(String smtpUser) {
		this.smtpUser = smtpUser;
	}

	public StateTypeLookup getHomeState() {
		return homeState;
	}

	public void setHomeState(StateTypeLookup homeState) {
		this.homeState = homeState;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public IpBom getIp() {
		return ip;
	}

	public void setIp(IpBom ip) {
		this.ip = ip;
	}

	public Set<CategoryBom> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryBom> categories) {
		this.categories = categories;
	}

	public int compareTo(StoreBom o) {
		return this.storeName.compareTo(o.storeName);
	}	
}
