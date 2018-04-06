package com.example.v5data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.v5data.model.TProduct;
import com.example.v5data.repository.TProductRepository;

@RestController
public class TProductController {

	@Autowired
	private TProductRepository tProductRepository;
	
	@RequestMapping("/product")
	public Page<TProduct> getAllProducts(Pageable p) {
		return tProductRepository.findAll(p);
	}
	
	@RequestMapping("/productSorted")
	public Iterable<TProduct> getSortedProducts() {
		return tProductRepository.findByOrderByNameAsc();	
	}
}
