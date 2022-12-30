package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	public boolean existsByUsername(String userName);
//
	public boolean existsByEmail(String email);
//
//	@Query("	SELECT 	status 		"
//			+ "	FROM 	User 		"
//			+ " WHERE 	email = :email")
//	public UserStatus findStatusByEmail(@Param("email") String email);
//
	public User findByUsername(String name);
//
	public User findByEmail(String email);
}
