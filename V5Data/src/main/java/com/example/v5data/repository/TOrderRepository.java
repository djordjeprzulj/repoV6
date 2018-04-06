package com.example.v5data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.v5data.model.TOrder;

public interface TOrderRepository extends JpaRepository<TOrder, Integer> {

}
