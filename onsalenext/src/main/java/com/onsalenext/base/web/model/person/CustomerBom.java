package com.onsalenext.base.web.model.person;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import com.onsalenext.base.domain.lookup.RoleTypeLookup;
import com.onsalenext.base.web.model.IpBom;

public class CustomerBom implements Comparable<CustomerBom>{

	private Long id; 
	private String firstName;
	private String lastName;
	private String phone;
	private Date dob;
	private boolean isActive;
	private RoleTypeLookup roleType;
    private WishListBom wishList;
	private UserInfoBom userInfo;
	private SubscriptionBom subscription;
    private Set<RegistryBom> registries = new TreeSet<RegistryBom>();
	private Set<AddressBom> addresses = new TreeSet <AddressBom> ();
	private Set<IpBom> ips = new TreeSet <IpBom> ();
	
	// constructor for item
	public CustomerBom (Long id, String firstName, String lastName, boolean isActive ) {
		
		this.id = id; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
	}
	
	public CustomerBom (Long id, String firstName, String lastName, String phone, Date dob, boolean isActive, 
			RoleTypeLookup roleType, WishListBom wishList, UserInfoBom userInfo, SubscriptionBom subscription, 
			Set<RegistryBom> registries, Set<AddressBom> addresses, Set<IpBom> ips){
		
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
	public RoleTypeLookup getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleTypeLookup roleType) {
		this.roleType = roleType;
	}
	public SubscriptionBom getSubscription() {
		return subscription;
	}
	public void setSubscription(SubscriptionBom subscription) {
		this.subscription = subscription;
	}
	public Set<RegistryBom> getRegistries() {
		return registries;
	}
	public void setRegistries(Set<RegistryBom> registries) {
		this.registries = registries;
	}
	public Set<AddressBom> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<AddressBom> addresses) {
		this.addresses = addresses;
	}
	public Set<IpBom> getIps() {
		return ips;
	}
	public void setIps(Set<IpBom> ips) {
		this.ips = ips;
	}
	public WishListBom getWishList() {
		return wishList;
	}
	public void setWishList(WishListBom wishList) {
		this.wishList = wishList;
	}
	public UserInfoBom getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoBom userInfo) {
		this.userInfo = userInfo;
	}
	public int compareTo(CustomerBom o) {
		return lastName.compareTo(o.lastName);
	}

	
}
