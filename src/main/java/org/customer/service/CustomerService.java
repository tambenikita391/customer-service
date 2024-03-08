package org.customer.service;

import org.customer.dto.AddUpdateCustomerRequest;
import org.customer.dto.AddUpdateCustomerResponse;
import org.customer.dto.SearchCustomerResponse;
import org.customer.entity.Customer;

public interface CustomerService {

	public AddUpdateCustomerResponse addCustomerDetails(AddUpdateCustomerRequest customerRequest);

	public SearchCustomerResponse searchCustomerByMobileNumber(String mobile_number);

	public AddUpdateCustomerResponse updateCustomerDetails(String customerId, AddUpdateCustomerRequest customerRequest);

}
