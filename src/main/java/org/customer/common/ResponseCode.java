package org.customer.common;

public enum ResponseCode {
	ADD_EMPLOYEE_SUCCESS("Success", "Customer details added successfully!!"),
	EXISTING_EMAIL("Fail", "Email is already exist! Please enter valid emailID!!"),
	EMPTY_FIRST_NAME("Missing", "First name is missing!!"), 
	EMPTY_LAST_NAME("Missing", "Last name is missing!!"),
	EMPTY_EMAIL_ID("Missing", "Email id is missing!!"), 
	SEARCH_CUSTOMER_FAIL("Fail", "Customer not found !!"),
	SEARCH_CUSTOMER_SUCCESS("Success", "Customer found successfully!!"),
	UPDATE_CUSTOMER_FAIL("Fail", "Customer not found !!"),
	UPDATE_CUSTOMER_SUCCESS("Success", "Customer details updated successfully!!");

	private final String status;
	private final String message;

	ResponseCode(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
