package in.glootech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.glootech.constaints.KafkaConstaints;
import in.glootech.entity.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;


	public String add(List<Customer> customer) {
		if(!customer.isEmpty()) {
			for(Customer customer2 : customer) {
				kafkaTemplate.send(KafkaConstaints.TOPIC,customer2);
				System.out.println("MSG published to kafka topic");
			}
		}
		return "Customer record added to kafka topic succesfully";
	}

}
