package com.vti.repository;

import com.vti.entity.Group;
import com.vti.entity.Product;
import com.vti.entity.User;
import com.vti.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

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

    Product findByProductName(String name);

    boolean existsByProductName(String name);

    void deleteByIdIn(List<Short> ids);
}
