package com.dollarsbank.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "userid"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(name = "name")
	private String name;
//	@Column(name = "userid")
	private String userid;
	
	private String pin;
	private Double amount;
	
	
	public User(String name, String userid, String pin, Double amount) {
		super();
		this.name = name;
		this.userid = userid;
		this.pin = pin;
		this.amount = amount;
	}
	public User() {
//		this.id = -1L;
//		this.name = "N/A";
//		this.userid = "N/A";
//		this.pin = "N/A";
//		this.amount = 0.00;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userid=" + userid + ", pin=" + pin + ", amount=" + amount + "]";
	}
}
