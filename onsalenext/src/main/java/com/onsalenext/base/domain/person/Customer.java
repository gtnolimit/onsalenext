package com.onsalenext.base.domain.person;

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

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.Ip;

import com.onsalenext.base.domain.lookup.RoleTypeLookup;

@Entity
@Table(name = "CUSTOMER", schema="ONSALENEXT_CUSTOMER")
public class Customer  extends DBBase implements Serializable{
	
	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	@Column(name = "FIRST_NAME", unique=false, nullable=false, length=250)
	private String firstName;
	@Column(name = "LAST_NAME", unique=false, nullable=false, length=250)
	private String lastName;
	@Column(name = "PHONE", unique=false, nullable=false, length=20)
	private String phone;
	@Column(name = "DOB", unique=false, nullable=true)
	private Date dob;
	@Column(name="STATUS")
	private boolean isActive;
	@OneToOne
	@JoinColumn (name="TYPE_ROLE")
	private RoleTypeLookup roleType;
		
	@OneToOne(cascade = CascadeType.ALL)
    private WishList wishList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserInfo userInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Subscription subscription;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="CUSTOMER_REGISTRY_LINK", 
                joinColumns={@JoinColumn(name="CUSTOMER_ID")}, 
                inverseJoinColumns={@JoinColumn(name="REGISTRY_ID")})
    private Set<Registry> registries = new HashSet<Registry>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_ADDRESS_LINK", 
		joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
	private Set<Address> addresses = new HashSet <Address> (0);
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_IP_LINK", 
		joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "IP_ID") })
	private Set<Ip> ips = new HashSet <Ip> (0);

	public Customer () {}
	
	public Customer (Long id, String firstName, String lastName, String phone, Date dob, boolean isActive, 
			RoleTypeLookup roleType, WishList wishList, UserInfo userInfo, Subscription subscription, 
			Set<Registry> registries, Set<Address> addresses, Set<Ip> ips, Date upd, String user){
		
		this.id = id; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.dob = dob;
		this.isActive = isActive;
		this.roleType = roleType;
		this.wishList = wishList;
		this.userInfo = userInfo;
		this.subscription = subscription;
		this.registries = registries;
		this.addresses = addresses;
		this.ips = ips;
		this.upd = upd;
		this.user = user;
	}
	
	public Customer (Long id, String firstName, String lastName, String phone, Date dob, boolean isActive, 
			RoleTypeLookup roleType, WishList wishList, UserInfo userInfo, Subscription subscription, 
			Set<Registry> registries, Set<Address> addresses, Set<Ip> ips, Date cpd, Date upd, String user){
		
		this.id = id; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.dob = dob;
		this.isActive = isActive;
		this.roleType = roleType;
		this.wishList = wishList;
		this.userInfo = userInfo;
		this.subscription = subscription;
		this.registries = registries;
		this.addresses = addresses;
		this.ips = ips;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Ip> getIps() {
		return ips;
	}

	public void setIps(Set<Ip> ips) {
		this.ips = ips;
	}

	public RoleTypeLookup getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleTypeLookup roleType) {
		this.roleType = roleType;
	}

	public WishList getWishList() {
		return wishList;
	}

	public void setWishList(WishList wishList) {
		this.wishList = wishList;
	}

	public Set<Registry> getRegistries() {
		return registries;
	}

	public void setRegistries(Set<Registry> registries) {
		this.registries = registries;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
