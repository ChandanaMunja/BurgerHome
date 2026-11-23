package com.burgerhome.burger_order_service.controller;

import com.burgerhome.burger_order_service.entity.FoodOrder;
import com.burgerhome.burger_order_service.service.OrderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController
{

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Place order
    @PostMapping
    public FoodOrder placeOrder(@RequestBody FoodOrder order) {
        return orderService.placeOrder(order);
    }

    // Get all orders
    @GetMapping
    public List<FoodOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get order by ID
    @GetMapping("/{id}")
    public FoodOrder getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
