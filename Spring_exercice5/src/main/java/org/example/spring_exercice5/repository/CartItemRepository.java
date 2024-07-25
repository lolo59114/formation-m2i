package org.example.spring_exercice5.repository;

import org.example.spring_exercice5.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findCartItemByFurniture_Id(Long id);
    List<CartItem> findAllByOrderByFurniture_Name();
}
