package com.example.v5data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.v5data.model.TProduct;

public interface TProductRepository extends JpaRepository<TProduct, Integer>{

	Iterable<TProduct> findByOrderByNameAsc();
}
