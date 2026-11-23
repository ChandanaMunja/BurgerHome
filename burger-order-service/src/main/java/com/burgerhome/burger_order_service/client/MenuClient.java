package com.burgerhome.burger_order_service.client;

import com.burgerhome.burger_order_service.dto.BurgerResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "burger-menu-service")
public interface MenuClient {

    @GetMapping("/api/burgers/{id}")
    BurgerResponse getBurgerById(
            @PathVariable("id") Long id
    );
}