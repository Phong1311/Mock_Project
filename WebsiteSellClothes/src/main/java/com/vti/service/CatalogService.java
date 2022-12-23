package com.vti.service;

import com.vti.dto.CatalogFormForCreating;
import com.vti.dto.CatalogFormForUpdating;
import com.vti.dto.GroupFormForCreating;
import com.vti.dto.GroupFormForUpdating;
import com.vti.dto.filter.GroupFilter;
import com.vti.entity.Catalog;
import com.vti.entity.Group;
import com.vti.repository.CatalogRepository;
import com.vti.repository.GroupRepository;
import com.vti.service.implement.ICatalogService;
import com.vti.specification.CatalogSpecificationBuilder;
import com.vti.specification.GroupSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogService implements ICatalogService {

	@Autowired
	private CatalogRepository repository;

	@Override
	public List<Catalog> getAllCatalogs(String search) {

		CatalogSpecificationBuilder specification = new CatalogSpecificationBuilder(search);

		return repository.findAll(specification.build());
	}

	@Override
	public Catalog getCatalogByID(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void createCatalog(CatalogFormForCreating form) {
		repository.save(form.toEntity());

	}

	@Override
	public void updateCatalog(int id, CatalogFormForUpdating form) {
		Catalog entity = repository.findById(id).get();
		entity.setName(form.getName());
		repository.save(entity);
	}

	@Override
	public void deleteCatalog(int id) {
		repository.deleteById(id);
	}


}
