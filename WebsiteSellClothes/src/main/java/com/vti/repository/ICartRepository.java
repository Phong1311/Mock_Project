package com.vti.repository;

import com.vti.entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart, Integer>, JpaSpecificationExecutor<Cart> {

    //getProductByUserId
    @Query(value = "SELECT * FROM CART WHERE userId = :idParameter", nativeQuery = true)
    Page<Cart> findAllByUserId(Pageable pageable, @Param("idParameter") int userId);

    //  delete cart
//    @Query(value = "DELETE from CART where userId = :idParameter", nativeQuery = true)
//    Page<Cart> findAllByUserId(Pageable pageable, @Param("idParameter") int userId);


}
