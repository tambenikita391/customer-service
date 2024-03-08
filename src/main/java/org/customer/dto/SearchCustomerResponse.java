package org.customer.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchCustomerResponse {

	private String status;
	private String message;
	
	@Autowired
	private CustomerData data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerData getData() {
		return data;
	}

	public void setData(CustomerData data) {
		this.data = data;
	}

	

}
