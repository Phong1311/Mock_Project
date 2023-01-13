package com.vti.service.implement;

import com.vti.entity.Cart;
import com.vti.form.creating.CartFormForCreating;
import com.vti.form.updating.CartFormForUpdating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICartService {

    Page<Cart> getAllCarts(Pageable pageable);

    Page<Cart> getCartByUserId(Pageable pageable, int userId);

    Cart getCartByUserIdAndProductId(int userId, int productId);

    void createCart(CartFormForCreating form);

    void updateQuantityInCart(int productId, int userId, CartFormForUpdating form);

    void deleteCartByUserId(int userId);

    void deleteProductInCartByProductId(int productId, int userId);

    int total(int userId);

    boolean existsCartByUserId(int userId);

    boolean existsCartByProductId(int userId);

}
