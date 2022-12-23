package com.vti.repository;

import com.vti.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Integer>, JpaSpecificationExecutor<Catalog> {

	 Catalog findByName(String name);

}
