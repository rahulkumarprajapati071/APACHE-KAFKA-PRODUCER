package in.glootech.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.glootech.entity.Customer;
import in.glootech.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(
				"/add"
			)
	public String addCustomer(@RequestBody List<Customer> customer) {
		return customerService.add(customer);
	}
	
	
	
}
