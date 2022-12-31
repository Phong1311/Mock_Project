package com.vti.controller;

import com.vti.dto.CartDTO;
import com.vti.dto.ProductDTO;
import com.vti.entity.Cart;
import com.vti.entity.Product;
import com.vti.form.creating.ProductFormForCreating;
import com.vti.form.filter.ProductFilter;
import com.vti.form.updating.ProductFormForUpdating;
import com.vti.service.implement.ICartService;
import com.vti.service.implement.IProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/carts")
public class CartController {

    @Autowired
    private ICartService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<?> getAllProducts(
            Pageable pageable) {
        Page<Cart> entities = service.getAllCarts(pageable);

        // convert entities --> dtos
        List<CartDTO> dtos = modelMapper.map(entities.getContent(), new TypeToken<List<CartDTO>>() {
        }.getType());

        Page<CartDTO> dtoPages = new PageImpl<>(dtos, pageable, entities.getTotalElements());

        return new ResponseEntity<>(dtoPages, HttpStatus.OK);
    }

    @GetMapping(value = "/userId/{id}")
    public ResponseEntity<?> getCartByUserId(Pageable pageable, @PathVariable(name = "id") int userId) {

        Page<Cart> cart = service.getCartByUserId(pageable, userId);

        // convert entities --> dtos
        List<CartDTO> dtos = modelMapper.map(cart.getContent(), new TypeToken<List<CartDTO>>() {
        }.getType());

        Page<CartDTO> dtoPages = new PageImpl<>(dtos, pageable, cart.getTotalElements());

//        CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);


        return new ResponseEntity<>(dtoPages, HttpStatus.OK);
    }
//
//    @PostMapping()
//    public ResponseEntity<?> createProduct(@RequestBody ProductFormForCreating form) {
//        service.createProduct(form);
//        return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
//    }
//
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<?> updateProduct(@PathVariable(name = "id") int id, @RequestBody ProductFormForUpdating form) {
//        service.updateProduct(id, form);
//        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/{ids}")
//    public ResponseEntity<?> deleteProducts(@PathVariable(name = "ids") List<Integer> ids) {
//        service.deleteProduct(ids);
//        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
//    }
}
