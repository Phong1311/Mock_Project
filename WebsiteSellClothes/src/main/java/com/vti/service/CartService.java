package com.vti.service;

import com.vti.entity.Cart;
import com.vti.form.creating.CartFormForCreating;
import com.vti.form.updating.CartFormForUpdating;
import com.vti.repository.ICartRepository;
import com.vti.service.implement.ICartService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartService implements ICartService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ICartRepository repository;

    @Override
    public Page<Cart> getAllCarts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Cart> getCartByUserId(Pageable pageable, int userId) {
        return repository.findAllByUserId(pageable, userId);
    }

    @Override
    public void createCart(CartFormForCreating form) {
        // omit id field

        Cart.ShoppingCartKey shoppingCartKey = modelMapper.map(form, Cart.ShoppingCartKey.class);


        TypeMap<CartFormForCreating, Cart> typeMap = modelMapper.getTypeMap(CartFormForCreating.class, Cart.class);
        if (typeMap == null) { // if not already added
            // skip field
            modelMapper.addMappings(new PropertyMap<CartFormForCreating, Cart>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        // convert form to entity
        Cart cart = modelMapper.map(form, Cart.class);
        cart.setId(shoppingCartKey);

        repository.save(cart);
    }

    @Override
    public void updateQuantityInCart(int productId, int userId, CartFormForUpdating form) {
        Cart entity = repository.findProductByProductIdAndUserId(productId, userId);
        entity.setQuantity(form.getQuantity());
        repository.save(entity);
    }


    @Override
    public void deleteCartByUserId(int userId) {
        repository.deleteCartByUserId(userId);
    }

    @Override
    public void deleteProductInCartByProductId(int userId) {
        repository.deleteProductInCartByProductId(userId);
    }


}
