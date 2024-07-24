package org.example.spring_exercice5.service;

import org.example.spring_exercice5.entity.CartItem;
import org.example.spring_exercice5.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartItemRepository cartItemRepository;
    private final FurnitureService furnitureService;

    public CartService(CartItemRepository cartItemRepository, FurnitureService furnitureService) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureService = furnitureService;
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getCartItemByFurnitureId(Long id) {
        return cartItemRepository.findCartItemByFurniture_Id(id);
    }

    public void addCartItem(Long furnitureId) {
        CartItem cartItem = getCartItemByFurnitureId(furnitureId);
        if(cartItem == null) {
            cartItem = new CartItem();
            cartItem.setFurniture(furnitureService.getFurnitureById(furnitureId));
            cartItem.setQuantity(1);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }
        cartItem.getFurniture().setStock(cartItem.getFurniture().getStock() - 1);
        cartItemRepository.save(cartItem);
    }

    public void removeCartItemById(Long id) {
        cartItemRepository.deleteById(id);
    }

    public void removeAllCartItems() {
        cartItemRepository.deleteAll();
    }
}
