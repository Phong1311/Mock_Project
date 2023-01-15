package com.vti.service;

import com.vti.form.creating.CatalogFormForCreating;
import com.vti.form.updating.CatalogFormForUpdating;
import com.vti.entity.Catalog;
import com.vti.repository.ICatalogRepository;
import com.vti.service.implement.ICatalogService;
import com.vti.specification.CatalogSpecificationBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatalogService implements ICatalogService {

    @Autowired
    private ICatalogRepository catalogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Catalog> getAllCatalogs(Pageable pageable, String search) {

        CatalogSpecificationBuilder specification = new CatalogSpecificationBuilder(search);

        return catalogRepository.findAll(specification.build(), pageable);
    }

    @Override
    public Catalog getCatalogByID(int id) {
        return catalogRepository.findById(id).get();
    }

    @Override
    public Catalog createCatalog(CatalogFormForCreating form) {

        // convert form to entity
        Catalog catalog = modelMapper.map(form, Catalog.class);
        catalogRepository.save(catalog);

        Catalog catalog1 = catalogRepository.findCatalogByName(form.getName());

        return catalog1;
    }

    @Override
    public Catalog updateCatalog(int id, CatalogFormForUpdating form) {
        Catalog entity = catalogRepository.findById(id).get();
        entity.setName(form.getName());
        entity.setImage(form.getImage());
        catalogRepository.save(entity);
        return entity;
    }

    @Override
    public void deleteCatalog(int id) {
        catalogRepository.deleteById(id);
    }


}
