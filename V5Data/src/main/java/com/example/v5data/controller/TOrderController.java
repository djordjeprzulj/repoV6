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

import com.example.v5data.model.TOrder;
import com.example.v5data.repository.TOrderRepository;

@RestController
@RequestMapping("/orders")
public class TOrderController {

	@Autowired
	private TOrderRepository tOrderRepository;
	
	@GetMapping
	public Iterable<TOrder> getAllOrders() {
		return tOrderRepository.findAll();
	}
	
	@GetMapping("/{orderId}")
	public Optional<TOrder> findOrder(@PathVariable int orderId) {
		return tOrderRepository.findById(orderId);
	}
		
	@PostMapping
	public TOrder insertOrder(@RequestBody TOrder tOrder) {
		return this.tOrderRepository.save(tOrder);
	}
	
	@DeleteMapping("/{orderId}")
	public void deleteOrder(@PathVariable int orderId) {
		this.tOrderRepository.deleteById(orderId);
	}
	
	@PutMapping("/{orderId}")
	public TOrder updateOrder(@PathVariable int orderId, @RequestBody TOrder tOrder) {
		return this.tOrderRepository.save(tOrder);
	}	
}
