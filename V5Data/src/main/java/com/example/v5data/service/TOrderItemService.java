package com.example.v5data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.v5data.model.TOrderItem;
import com.example.v5data.repository.TOrderItemRepository;

@Service
public class TOrderItemService {

	@Autowired
	private TOrderItemRepository tOrderItemRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Iterable<TOrderItem> findAll() {
		return tOrderItemRepository.findAll();
	}
	
	public int getNextSeqNumberForOrder(int orderId) {
		return jdbcTemplate.queryForObject("select max(seq_num)+1 "
										+ "from t_order_item "
										+ "where order_id="+orderId, Integer.class);
	}
}
