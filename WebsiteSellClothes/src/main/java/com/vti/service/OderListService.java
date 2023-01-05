package com.vti.service;

import com.vti.entity.OderList;
import com.vti.entity.User;
import com.vti.repository.IOderListRepository;
import com.vti.repository.IUserRepository;
import com.vti.service.implement.IOderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderListService implements IOderListService {

    @Autowired
    private IOderListRepository repository;

    @Autowired
    private IUserRepository IUserRepository;


//	@Override
//	public Page<Catalog> getAllCatalogs(Pageable pageable, String search) {
//
//		CatalogSpecificationBuilder specification = new CatalogSpecificationBuilder(search);
//
//		return repository.findAll(specification.build(),pageable);
//	}
//
//	@Override
//	public Catalog getCatalogByID(int id) {
//		return repository.findById(id).get();
//	}
//
//	@Override
//	public void createCatalog(CatalogFormForCreating form) {
//		repository.save(form.toEntity());
//
//	}
//
//	@Override
//	public void updateCatalog(int id, CatalogFormForUpdating form) {
//		Catalog entity = repository.findById(id).get();
//		entity.setName(form.getName());
//		repository.save(entity);
//	}
//
//	@Override
//	public void deleteCatalog(int id) {
//		repository.deleteById(id);
//	}


    @Override
    public Page<OderList> getOderListByUsername(Pageable pageable, String username) {
        return repository.findByUserUsername(pageable, username);
    }

    @Override
    public Page<OderList> getOderListByUsernameAndStatus(Pageable pageable, String username, OderList.Status status) {
        return repository.findByUserUsernameAndStatus(pageable, username, status);
    }
}
