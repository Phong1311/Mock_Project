package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Short>, JpaSpecificationExecutor<Group> {

	 Group findByName(String name);

	 boolean existsByName(String name);

	 void deleteByIdIn(List<Short> ids);
}
