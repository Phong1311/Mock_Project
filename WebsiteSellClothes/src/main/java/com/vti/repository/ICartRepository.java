package com.vti.repository;

import com.vti.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICartRepository extends JpaRepository<Cart, Integer>, JpaSpecificationExecutor<Cart> {

}
