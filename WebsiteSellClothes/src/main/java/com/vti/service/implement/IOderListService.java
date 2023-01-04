package com.vti.service.implement;

import com.vti.entity.Catalog;
import com.vti.entity.OderList;
import com.vti.form.creating.CatalogFormForCreating;
import com.vti.form.updating.CatalogFormForUpdating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOderListService {

//	Page<Catalog> getAllCatalogs(Pageable pageable, String search);

	Page<OderList> getOderListByUsername(Pageable pageable, String username);

//	void createCatalog(CatalogFormForCreating form);
//
//	void updateCatalog(int id, CatalogFormForUpdating form);
//
//	void deleteCatalog(int id);

}
