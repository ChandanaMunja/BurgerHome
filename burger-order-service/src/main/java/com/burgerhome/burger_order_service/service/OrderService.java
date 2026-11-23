package com.burgerhome.burger_order_service.service;

import com.burgerhome.burger_order_service.client.MenuClient;
import com.burgerhome.burger_order_service.dto.BurgerResponse;
import com.burgerhome.burger_order_service.entity.FoodOrder;
import com.burgerhome.burger_order_service.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuClient menuClient;

    public OrderService(
            OrderRepository orderRepository,
            MenuClient menuClient) {

        this.orderRepository = orderRepository;
        this.menuClient = menuClient;
    }

    // Place order
    public FoodOrder placeOrder(FoodOrder order) {

        // Get burger details from Menu Service
        BurgerResponse burger = menuClient.getBurgerById(
                order.getBurgerId()
        );

        // Check burger availability
        if (!Boolean.TRUE.equals(burger.getAvailable())) {
            throw new RuntimeException("Burger is not available!");
        }

        // Calculate total price
        Double totalPrice = burger.getPrice() * order.getQuantity();

        order.setTotalPrice(totalPrice);
        order.setStatus("PLACED");

        // Save order in Order Database
        return orderRepository.save(order);
    }

    // Get all orders
    public List<FoodOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public FoodOrder getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with ID: " + id)
                );
    }
}