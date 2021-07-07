package com.bank.exception;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class CustomErrorDetails {
	private Date timestamp;
	private String message;
	private String errorDatails;

	public CustomErrorDetails(Date timestamp, String message, String errorDatails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errorDatails = errorDatails;
	}

	public CustomErrorDetails() {
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorDatails() {
		return errorDatails;
	}

	public void setErrorDatails(String errorDatails) {
		this.errorDatails = errorDatails;
	}

}
