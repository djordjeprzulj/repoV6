package com.example.v5data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.v5data.model.TOrderItem;
import com.example.v5data.repository.TOrderItemRepository;

@RestController
public class TOrderItemController {

	@Autowired
	private TOrderItemRepository tOrderItemRepository;
	
	@RequestMapping("/orderItem")
	public Iterable<TOrderItem> getAllOrderItems() {
		return tOrderItemRepository.findAll();
	}
}
