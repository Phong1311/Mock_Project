package com.vti.repository;

import com.vti.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

//	public boolean existsByUserName(String userName);
//
//	public boolean existsByEmail(String email);
//
//	@Query("	SELECT 	status 		"
//			+ "	FROM 	User 		"
//			+ " WHERE 	email = :email")
//	public UserStatus findStatusByEmail(@Param("email") String email);
//
//	public User findByUserName(String name);
//
//	public User findByEmail(String email);

//    Product findByName(String name);
//
//    boolean existsByName(String name);
//
    void deleteByIdIn(List<Integer> ids);
}
