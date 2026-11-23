package com.burgerhome.burger_menu_service.repository;

import com.burgerhome.burger_menu_service.entity.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository
        extends JpaRepository<Burger, Long> {

}