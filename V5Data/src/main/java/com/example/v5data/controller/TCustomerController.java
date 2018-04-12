package com.example.v5data.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.v5data.model.TCustomer;
import com.example.v5data.repository.TCustomerRepository;

@RestController
@RequestMapping("/customers")
public class TCustomerController {

	@Autowired
	private TCustomerRepository tCustomerRepository;
	
	@GetMapping
	public Iterable<TCustomer> getAllCustomers() {
		return tCustomerRepository.findAll();
	}
	
	@GetMapping("/{customerId}")
	public Optional<TCustomer> findCustomer(@PathVariable int customerId) {
		return tCustomerRepository.findById(customerId);
	}
	
	@GetMapping("/findByFirstName/{firstName}")
	public Iterable<TCustomer> findCustomersByFirstName(@PathVariable String firstName) {
		return tCustomerRepository.findByFirstName(firstName);
	}
	
	@PostMapping
	public TCustomer insertCustomer(@RequestBody TCustomer tCustomer) {
		return this.tCustomerRepository.save(tCustomer);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		this.tCustomerRepository.deleteById(customerId);
	}
	
	@PutMapping("/{customerId}")
	public TCustomer updateCustomer(@PathVariable int customerId, @RequestBody TCustomer tCustomer) {
		return this.tCustomerRepository.save(tCustomer);
	}
}
