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
    Page<Cart> findAllByUserId(Pageable pageable, int userId);


    //getProductByProductIdAndUserId
    Cart findCartByProductIdAndUserId(int productId,int userId);

    //  delete cart
    @Modifying
    @Query(value = "DELETE FROM CART WHERE userId = :idParameter", nativeQuery = true)
    void deleteCartByUserId(@Param("idParameter") int userId);

    // delete product in cart
    @Modifying
    @Query(value = "DELETE FROM CART WHERE productId = :proIdParameter AND userId = :useIdParameter", nativeQuery = true)
    void deleteProductInCartByProductId(@Param("proIdParameter") int productId, @Param("useIdParameter") int userId);

    // tính tổng
    @Query(value = "SELECT Sum(p.salePrice * c.quantity) as total FROM PRODUCT p\n" +
            "JOIN CART c\n" +
            "USING (productId)\n" +
            "WHERE c.userId = :useIdParameter", nativeQuery = true)
    int total(@Param("useIdParameter") int userId);

    boolean existsByUserId(int userId);

    boolean existsByProductId(int productId);
}
