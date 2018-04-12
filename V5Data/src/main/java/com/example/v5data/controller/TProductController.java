package com.example.v5data.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.v5data.model.TProduct;
import com.example.v5data.repository.TProductRepository;

@RestController
@RequestMapping("/products")
public class TProductController {

	@Autowired
	private TProductRepository tProductRepository;
	
	@GetMapping
	public Iterable<TProduct> getAllProducts() {
		return tProductRepository.findAll();
	}
	
	@GetMapping("/paged")
	public Page<TProduct> getPagedProducts(Pageable p) {
		return tProductRepository.findAll(p);
	}
	
	@GetMapping("/sorted")
	public Iterable<TProduct> getSortedProducts() {
		return tProductRepository.findByOrderByNameAsc();	
	}
	
	@GetMapping("/{productId}")
	public Optional<TProduct> findProduct(@PathVariable int productId) {
		return tProductRepository.findById(productId);
	}
		
	@PostMapping
	public TProduct insertProduct(@RequestBody TProduct tProduct) {
		return this.tProductRepository.save(tProduct);
	}
	
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		this.tProductRepository.deleteById(productId);
	}
	
	@PutMapping("/{productId}")
	public TProduct updateProduct(@PathVariable int productId, @RequestBody TProduct tProduct) {
		return this.tProductRepository.save(tProduct);
	}	
}
