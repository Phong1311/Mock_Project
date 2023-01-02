package com.vti.repository;

import com.vti.entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICartRepository extends JpaRepository<Cart, Cart.ShoppingCartKey>, JpaSpecificationExecutor<Cart> {

    //getProductByUserId
    @Query(value = "SELECT * FROM CART WHERE userId = :idParameter", nativeQuery = true)
    Page<Cart> findAllByUserId(Pageable pageable, @Param("idParameter") int userId);

    //getProductByProductId
    @Query(value = "SELECT * FROM CART WHERE productId = :proIdParameter AND userId = :useIdParameter", nativeQuery = true)
    Cart findProductByProductIdAndUserId(@Param("proIdParameter") int productId, @Param("useIdParameter") int userId );

    //  delete cart
    @Modifying
    @Query(value = "DELETE FROM CART WHERE userId = :idParameter", nativeQuery = true)
    void deleteCartByUserId(@Param("idParameter") int userId);

    // delete product in cart
    @Modifying
    @Query(value = "DELETE FROM CART WHERE productId = :idParameter", nativeQuery = true)
    void deleteProductInCartByProductId(@Param("idParameter") int productId);

    // update quantity by product
//    @Modifying
//    @Query(value = "UPDATE cart SET quantity = 20 WHERE productId = :idParameter", nativeQuery = true)
//    void updateQuantityByProductId(@Param("idParameter") int productId, );

}
