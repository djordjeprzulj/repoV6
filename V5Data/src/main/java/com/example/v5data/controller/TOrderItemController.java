package com.example.v5data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.v5data.model.TOrderItem;
import com.example.v5data.service.TOrderItemService;

@RestController
public class TOrderItemController {

	@Autowired
	private TOrderItemService tOrderItemService;
	
	@RequestMapping("/orderItem")
	public Iterable<TOrderItem> getAllOrderItems() {
		return tOrderItemService.findAll();
	}
	
	@RequestMapping("/nextSeqNumForOrder2")
	public int nextSeqNumForOrder2() {
		return tOrderItemService.getNextSeqNumberForOrder(2);
	}
}
