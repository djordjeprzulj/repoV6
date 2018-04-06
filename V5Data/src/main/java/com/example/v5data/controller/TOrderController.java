package com.example.v5data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.v5data.repository.TOrderRepository;

@RestController
public class TOrderController {

	@Autowired
	private TOrderRepository tOrderRepository;
	
}
