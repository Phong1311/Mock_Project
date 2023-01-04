package com.vti.service.implement;

import com.vti.entity.OderDetail;
import com.vti.entity.OderList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOderDetailService {

//	Page<Catalog> getAllCatalogs(Pageable pageable, String search);

	Page<OderDetail> getByOderListId(Pageable pageable, int oderId);

//	void createCatalog(CatalogFormForCreating form);
//
//	void updateCatalog(int id, CatalogFormForUpdating form);
//
//	void deleteCatalog(int id);

}
