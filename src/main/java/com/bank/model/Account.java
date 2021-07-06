package com.bank.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity(name = "account")
public class Account {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	@NotEmpty(message = "name can't be null")
	private String name;
	
	@Column(name = "account_type")
	private String type;
	
	@Column(name = "account_opnedate")
	private LocalDate openDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", type=" + type + ", openDate=" + openDate + "]";
	}

}
