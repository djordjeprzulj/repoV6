package com.example.v5data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.v5data.model.TOrder;
import com.example.v5data.model.TOrderItem;
import com.example.v5data.repository.TOrderItemRepository;
import com.example.v5data.repository.TOrderRepository;

@Service
public class TOrderService {

	@Autowired
	TOrderRepository tOrderRepository;
	
	@Autowired
	TOrderItemRepository tOrderItemRepository;
	
	
	@Transactional
	public void insertOrderAndItems(TOrder order) {
		tOrderRepository.save(order);
		for (TOrderItem item : order.getTOrderItems())
			tOrderItemRepository.save(item);
	}
}
