package com.burgerhome.burger_menu_service.controller;

import com.burgerhome.burger_menu_service.entity.Burger;
import com.burgerhome.burger_menu_service.service.BurgerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/burgers")
@CrossOrigin(origins = "*")
public class BurgerController {

    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    // Add burger
    @PostMapping
    public Burger addBurger(@RequestBody Burger burger) {
        return burgerService.addBurger(burger);
    }

    // Get all burgers
    @GetMapping
    public List<Burger> getAllBurgers() {
        return burgerService.getAllBurgers();
    }

    // Get burger by ID
    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id) {
        return burgerService.getBurgerById(id);
    }

    // Update burger
    @PutMapping("/{id}")
    public Burger updateBurger(
            @PathVariable Long id,
            @RequestBody Burger burger) {

        return burgerService.updateBurger(id, burger);
    }

    // Delete burger
    @DeleteMapping("/{id}")
    public String deleteBurger(@PathVariable Long id) {

        burgerService.deleteBurger(id);

        return "Burger deleted successfully!";
    }
}