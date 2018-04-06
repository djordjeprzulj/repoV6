package com.example.v5data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.v5data.model.TCustomer;
import com.example.v5data.repository.TCustomerRepository;

@RestController
public class TCustomerController {

	@Autowired
	private TCustomerRepository tCustomerRepository;
	
	@RequestMapping("/customer")
	public Iterable<TCustomer> getAllCustomers() {
		return tCustomerRepository.findAll();
	}
}
