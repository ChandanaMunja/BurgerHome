package com.burgerhome.burger_menu_service.service;

import com.burgerhome.burger_menu_service.entity.Burger;
import com.burgerhome.burger_menu_service.repository.BurgerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurgerService {

    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    // Add burger
    public Burger addBurger(Burger burger) {
        return burgerRepository.save(burger);
    }

    // Get all burgers
    public List<Burger> getAllBurgers() {
        return burgerRepository.findAll();
    }

    // Get burger by ID
    public Burger getBurgerById(Long id) {
        return burgerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Burger not found with ID: " + id)
                );
    }

    // Update burger
    public Burger updateBurger(Long id, Burger burger) {

        Burger existingBurger = getBurgerById(id);

        existingBurger.setName(burger.getName());
        existingBurger.setDescription(burger.getDescription());
        existingBurger.setPrice(burger.getPrice());
        existingBurger.setCategory(burger.getCategory());
        existingBurger.setAvailable(burger.getAvailable());

        return burgerRepository.save(existingBurger);
    }

    // Delete burger
    public void deleteBurger(Long id) {

        Burger burger = getBurgerById(id);

        burgerRepository.delete(burger);
    }
}