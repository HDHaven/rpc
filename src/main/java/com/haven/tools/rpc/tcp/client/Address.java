package com.haven.tools.rpc.tcp.client;

import java.io.Serializable;

/**
 * <p>地址信息实体类
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long userId;
	private String province;
	private String city;
	private String street;
	private String number;
	private String linkMan;
	private String linkPhone;
	
	public Address() {}

	public Address(Long id, Long userId, String province, String city, String street, String number, String linkMan,
			String linkPhone) {
//		super();
		this.id = id;
		this.userId = userId;
		this.province = province;
		this.city = city;
		this.street = street;
		this.number = number;
		this.linkMan = linkMan;
		this.linkPhone = linkPhone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", province=" + province + ", city=" + city + ", street="
				+ street + ", number=" + number + ", linkMan=" + linkMan + ", linkPhone=" + linkPhone + "]";
	}
	
}
