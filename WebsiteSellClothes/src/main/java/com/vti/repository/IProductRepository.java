package com.vti.repository;

import com.vti.entity.Cart;
import com.vti.entity.Comment;
import com.vti.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {


    @Modifying
    void deleteByIdIn(List<Integer> ids);



}
