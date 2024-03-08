import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.customer.CustomerServiceMain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = CustomerServiceMain.class)
public class CustomerServiceControllerIntegrationTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	@Order(1)
	public void verifyCustomerServiceForSuccessfulInsertion() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/customer/add")
				.content("\"firstName\": \"Nikita\",\r\n" 
		                + " \"lastName\":\"Tambe\",\r\n"
						+ " \"midddleName\":\"Suryakant\",\r\n" 
		                + " \"dateOfBirth\":\"15-06-2003\",\r\n"
						+ " \"addressLine1\":\"Pune\",\r\n" 
		                + " \"addressLine2\":\"Solapur\",\r\n"
						+ " \"zip\":\"413502\",\r\n" 
		                + " \"city\":\"Bhooom\",\r\n" 
						+ " \"state\":\"Maharashtra\",\r\n"
						+ " \"country\":\"India\",\r\n" 
						+ " \"mobilePhone\":\"1111119587\",\r\n"
						+ " \"homePhone\":\"8754784235\",\r\n" 
						+ " \"workPhone\":\"9654986375\",\r\n"
						+ " \"emailID\":\"tambe987@gmail.com\",\r\n" 
						+ " \"customerId\":12")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE);

		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Success"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Customer added successfully!!"))
				.andReturn();
	}

	@Test
	@Order(2)
	public void verifyCustomerServiceForIfEmailAlreadyExist() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/customer/add")
				.content("  \"firstName\": \"Nikita\",\r\n"
		                + " \"lastName\":\"Tambe\",\r\n"
						+ " \"midddleName\":\"Suryakant\",\r\n" 
		                + " \"dateOfBirth\":\"15-06-2003\",\r\n"
						+ " \"addressLine1\":\"Pune\",\r\n" 
		                + " \"addressLine2\":\"Solapur\",\r\n"
						+ " \"zip\":\"413502\",\r\n" 
		                + " \"city\":\"Bhooom\",\r\n" 
						+ " \"state\":\"Maharashtra\",\r\n"
						+ " \"country\":\"India\",\r\n" 
		                + " \"mobilePhone\":\"1111119587\",\r\n"
						+ " \"homePhone\":\"8754784235\",\r\n" 
		                + " \"workPhone\":\"9654986375\",\r\n"
						+ " \"emailID\":\"ntambe24@gmail.com\",\r\n" 
		                + " \"customerId\":76")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE);

		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Error")).andExpect(MockMvcResultMatchers
						.jsonPath("$.message").value("Email is already exist! Please enter valid emailID"))
				.andReturn();
	}

}
