package org.customer.controller;

import org.customer.dto.AddUpdateCustomerRequest;
import org.customer.dto.AddUpdateCustomerResponse;
import org.customer.dto.SearchCustomerResponse;
import org.customer.entity.Customer;
import org.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class CustomerServiceController {

	@Autowired
	CustomerServiceImpl CustomerServiceImpl;

	@PostMapping(path = "/api/v1/customer/add", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public AddUpdateCustomerResponse addCustomerDetails(@Valid @RequestBody AddUpdateCustomerRequest request) {
		return CustomerServiceImpl.addCustomerDetails(request);
	}

	@PostMapping(path = "/api/v1/customer/update/{customerId}", consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public AddUpdateCustomerResponse addCustomerDetails(@Valid @PathVariable String customerId,
			@RequestBody AddUpdateCustomerRequest request) {
		return CustomerServiceImpl.updateCustomerDetails(customerId, request);
	}

	@GetMapping(path = "/api/v1/customer/search/{mobile_number}", consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public SearchCustomerResponse searchCustomerByMobileNumber(@PathVariable String mobile_number) {
		return CustomerServiceImpl.searchCustomerByMobileNumber(mobile_number);
	}

}
