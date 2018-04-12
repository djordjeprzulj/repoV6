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

import com.example.v5data.model.TOrderItem;
import com.example.v5data.service.TOrderItemService;

@RestController
@RequestMapping("/orderItems")
public class TOrderItemController {

	@Autowired
	private TOrderItemService tOrderItemService;
	
	@GetMapping
	public Iterable<TOrderItem> getAllOrderItems() {
		return tOrderItemService.findAll();
	}
	
	@RequestMapping("/nextSeqNumForOrder/{orderId}")
	public int nextSeqNumForOrder(@PathVariable int orderId) {
		return tOrderItemService.getNextSeqNumberForOrder(orderId);
	}
	
	@GetMapping("/{orderItemId}")
	public Optional<TOrderItem> findOrderItem(@PathVariable int orderItemId) {
		return tOrderItemService.findById(orderItemId);
	}
		
	@PostMapping
	public TOrderItem insertOrder(@RequestBody TOrderItem tOrderItem) {
		return this.tOrderItemService.save(tOrderItem);
	}
	
	@DeleteMapping("/{orderItemId}")
	public void deleteOrder(@PathVariable int orderItemId) {
		this.tOrderItemService.deleteById(orderItemId);
	}
	
	@PutMapping("/{orderItemId}")
	public TOrderItem updateOrder(@PathVariable int orderItemId, @RequestBody TOrderItem tOrderItem) {
		return this.tOrderItemService.save(tOrderItem);
	}
}
