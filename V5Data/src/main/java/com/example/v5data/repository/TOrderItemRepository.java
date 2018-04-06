package com.example.v5data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.v5data.model.TOrderItem;

public interface TOrderItemRepository extends JpaRepository<TOrderItem, Integer> {

}
