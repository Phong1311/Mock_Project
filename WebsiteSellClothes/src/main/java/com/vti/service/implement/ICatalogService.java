package com.vti.service.implement;

import com.vti.dto.CatalogFormForCreating;
import com.vti.dto.CatalogFormForUpdating;
import com.vti.dto.GroupFormForCreating;
import com.vti.dto.GroupFormForUpdating;
import com.vti.dto.filter.GroupFilter;
import com.vti.entity.Catalog;
import com.vti.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICatalogService {

	List<Catalog> getAllCatalogs(String search);

	Catalog getCatalogByID(int id);

	void createCatalog(CatalogFormForCreating form);

	void updateCatalog(int id, CatalogFormForUpdating form);

	void deleteCatalog(int id);

}
