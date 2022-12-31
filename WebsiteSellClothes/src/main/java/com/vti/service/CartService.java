package com.vti.service;

import com.vti.entity.Cart;
import com.vti.form.creating.CartFormForCreating;
import com.vti.form.updating.CartFormForUpdating;
import com.vti.repository.ICartRepository;
import com.vti.service.implement.ICartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    }

    @Override
    public void updateCart(int productId, CartFormForUpdating form) {

    }

    @Override
    public void deleteCartByProductId(int productId) {

    }

//    @Override
//    public void createCart(ProductFormForCreating form) {
//        // omit id field
//        TypeMap<ProductFormForCreating, Product> typeMap = modelMapper.getTypeMap(ProductFormForCreating.class, Product.class);
//        if (typeMap == null) { // if not already added
//            // skip field
//            modelMapper.addMappings(new PropertyMap<ProductFormForCreating, Product>() {
//                @Override
//                protected void configure() {
//                    skip(destination.getId());
//                }
//            });
//        }
//        // convert form to entity
//        Product product = modelMapper.map(form, Product.class);
//
//        repository.save(product);
//
//    }

//    @Override
//    public void updateCart(int id, ProductFormForUpdating form) {
//        Product entity = repository.findById(id).get();
//        entity.setName(form.getName());
//        entity.setDescribe(form.getDescribe());
//        entity.setSize(form.getSize());
//        entity.setAmount(form.getAmount());
//        entity.setPurchasePrice(form.getPurchasePrice());
//        entity.setPrice(form.getPrice());
//        entity.setSalePrice(form.getSalePrice());
//        repository.save(entity);
//    }


//    @Override
//    public void deleteCartByProductId(List<Integer> ids) {
//        repository.deleteByIdIn(ids);
//
//    }
}
