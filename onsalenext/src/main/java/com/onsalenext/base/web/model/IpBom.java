package com.onsalenext.base.web.model;

public class IpBom  implements Comparable<IpBom>{

	private Long id; 
	private String ip;
	private String session;
	
	public IpBom ( Long id, String ip, String session ){
		this.id = id;
		this.ip = ip;
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
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}

	public int compareTo(IpBom o) {
		return this.ip.compareTo(o.ip);
	}

	
}
