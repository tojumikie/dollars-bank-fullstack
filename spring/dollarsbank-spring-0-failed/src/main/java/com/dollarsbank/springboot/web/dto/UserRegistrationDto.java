package com.dollarsbank.springboot.web.dto;

public class UserRegistrationDto {
	private String name;
	private String userid;
	private String pin;
	private Double amount;
	
	public UserRegistrationDto(String name, String userid, String pin, Double amount) {
		super();
		this.name = name;
		this.userid = userid;
		this.pin = pin;
		this.amount = amount;
	}
	
	public UserRegistrationDto() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
