package org.customer.service;

import java.time.LocalDateTime;
import java.util.List;

import org.customer.common.ResponseCode;
import org.customer.dto.AddUpdateCustomerRequest;
import org.customer.dto.AddUpdateCustomerResponse;
import org.customer.dto.SearchCustomerResponse;
import org.customer.entity.Customer;
import org.customer.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	AddUpdateCustomerResponse customerResponse;

	@Autowired
	SearchCustomerResponse searchCustomerResponse;

	@Override
	public AddUpdateCustomerResponse addCustomerDetails(AddUpdateCustomerRequest customerRequest) {

		if (customerRepo.existsByEmail_id(customerRequest.getEmailID())) {
			customerResponse.setStatus(ResponseCode.EXISTING_EMAIL.getStatus());
			customerResponse.setMessage(ResponseCode.EXISTING_EMAIL.getMessage());

		} else if (customerRequest.getFirstName() == null) {
			customerResponse.setMessage(ResponseCode.EMPTY_FIRST_NAME.getStatus());
			customerResponse.setMessage(ResponseCode.EMPTY_FIRST_NAME.getMessage());
		} else if (customerRequest.getLastName() == null) {
			customerResponse.setStatus(ResponseCode.EMPTY_LAST_NAME.getStatus());
			customerResponse.setMessage(ResponseCode.EMPTY_LAST_NAME.getMessage());
		} else if (customerRequest.getEmailID() == null) {
			customerResponse.setStatus(ResponseCode.EMPTY_EMAIL_ID.getStatus());
			customerResponse.setMessage(ResponseCode.EMPTY_EMAIL_ID.getMessage());
		} else {

			Customer customerTable = Customer.getInstance().setFirst_name(customerRequest.getFirstName())
					.setMiddle_name(customerRequest.getMiddleName()).setLast_name(customerRequest.getLastName())
					.setDate_of_birth(customerRequest.getDateOfBirth())
					.setAddress_line1(customerRequest.getAddressLine1())
					.setAddress_line2(customerRequest.getAddressLine2()).setZip(customerRequest.getZip())
					.setCity(customerRequest.getCity()).setState(customerRequest.getState())
					.setCountry(customerRequest.getCountry()).setMobile_phone(customerRequest.getMobilePhone())
					.setHome_phone(customerRequest.getHomePhone()).setWork_phone(customerRequest.getWorkPhone())
					.setEmail_id(customerRequest.getEmailID()).setCustomer_id(customerRequest.getCustomerId())
					.setCreated_date(LocalDateTime.now()).setUpdated_date(LocalDateTime.now());

			try {
				customerTable = customerRepo.save(customerTable);
			} catch (Exception e) {
				e.printStackTrace();
			}

			customerResponse.setStatus(ResponseCode.ADD_EMPLOYEE_SUCCESS.getStatus());
			customerResponse.setMessage(ResponseCode.ADD_EMPLOYEE_SUCCESS.getMessage());

		}
		return customerResponse;
	}

	public SearchCustomerResponse searchCustomerByMobileNumber(String mobile_number) {

		List<Customer> receivedData = customerRepo.findByMobileNumber(mobile_number);

		if (receivedData == null || receivedData.isEmpty()) {
			searchCustomerResponse.setStatus(ResponseCode.SEARCH_CUSTOMER_FAIL.getStatus());
			searchCustomerResponse.setMessage(ResponseCode.SEARCH_CUSTOMER_FAIL.getMessage());
		} else {

			Customer customer = receivedData.get(0);
			searchCustomerResponse.setStatus(ResponseCode.SEARCH_CUSTOMER_SUCCESS.getStatus());
			searchCustomerResponse.setMessage(ResponseCode.SEARCH_CUSTOMER_SUCCESS.getMessage());

			searchCustomerResponse.getData().setFirstName(customer.getFirst_name());
			searchCustomerResponse.getData().setLastName(customer.getLast_name());
			searchCustomerResponse.getData().setMiddleName(customer.getMiddle_name());
			searchCustomerResponse.getData().setDateOfBirth(customer.getDate_of_birth());
			searchCustomerResponse.getData().setAddressLine1(customer.getAddress_line1());
			searchCustomerResponse.getData().setAddressLine2(customer.getAddress_line2());
			searchCustomerResponse.getData().setZip(customer.getZip());
			searchCustomerResponse.getData().setCity(customer.getCity());
			searchCustomerResponse.getData().setState(customer.getState());
			searchCustomerResponse.getData().setCountry(customer.getCountry());
			searchCustomerResponse.getData().setMobilePhone(customer.getMobile_phone());
			searchCustomerResponse.getData().setHomePhone(customer.getHome_phone());
			searchCustomerResponse.getData().setWorkPhone(customer.getWork_phone());
			searchCustomerResponse.getData().setEmailID(customer.getEmail_id());
		}

		return searchCustomerResponse;

	}

	public AddUpdateCustomerResponse updateCustomerDetails(String customerId,
			AddUpdateCustomerRequest customerRequest) {

		List<Customer> receivedData = customerRepo.findByCustomerId(customerId);
		if (receivedData == null || receivedData.isEmpty()) {
			customerResponse.setStatus(ResponseCode.UPDATE_CUSTOMER_FAIL.getStatus());
			customerResponse.setMessage(ResponseCode.UPDATE_CUSTOMER_FAIL.getMessage());
		} else {
			Customer customerTable = Customer.getInstance().setFirst_name(customerRequest.getFirstName())
					.setMiddle_name(customerRequest.getMiddleName()).setLast_name(customerRequest.getLastName())
					.setDate_of_birth(customerRequest.getDateOfBirth())
					.setAddress_line1(customerRequest.getAddressLine1())
					.setAddress_line2(customerRequest.getAddressLine2()).setZip(customerRequest.getZip())
					.setCity(customerRequest.getCity()).setState(customerRequest.getState())
					.setCountry(customerRequest.getCountry()).setMobile_phone(customerRequest.getMobilePhone())
					.setHome_phone(customerRequest.getHomePhone()).setWork_phone(customerRequest.getWorkPhone())
					.setEmail_id(customerRequest.getEmailID()).setCustomer_id(customerRequest.getCustomerId())
					.setCreated_date(LocalDateTime.now()).setUpdated_date(LocalDateTime.now());

			try {
				customerTable = customerRepo.save(customerTable);
			} catch (Exception e) {
				e.printStackTrace();
			}

			customerResponse.setStatus(ResponseCode.UPDATE_CUSTOMER_SUCCESS.getStatus());
			customerResponse.setMessage(ResponseCode.UPDATE_CUSTOMER_SUCCESS.getMessage());

		}

		return customerResponse;

	}

}
