package com.burgerhome.burger_order_service.repository;

import com.burgerhome.burger_order_service.entity.FoodOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository<FoodOrder, Long> {

}