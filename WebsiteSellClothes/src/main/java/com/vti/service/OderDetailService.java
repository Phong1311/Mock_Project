//package com.vti.service;
//
//import com.vti.dto.CatalogDTO;
//import com.vti.dto.OderDetailDTO;
//import com.vti.entity.OderDetail;
//import com.vti.entity.OderList;
//import com.vti.repository.IOderListRepository;
//import com.vti.repository.IUserRepository;
//import com.vti.service.implement.IOderDetailService;
//import com.vti.service.implement.IOderListService;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service

import org.springframework.transaction.annotation.Transactional;

//@Transactional
//public class OderDetailService implements IOderDetailService {
//
//    @Autowired
//    private IOderDetailService repository;
//
//    @Autowired
//    private IUserRepository IUserRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
////	@Override
////	public Page<Catalog> getAllCatalogs(Pageable pageable, String search) {
////
////		CatalogSpecificationBuilder specification = new CatalogSpecificationBuilder(search);
////
////		return repository.findAll(specification.build(),pageable);
////	}
////
////	@Override
////	public Catalog getCatalogByID(int id) {
////		return repository.findById(id).get();
////	}
////
////	@Override
////	public void createCatalog(CatalogFormForCreating form) {
////		repository.save(form.toEntity());
////
////	}
////
////	@Override
////	public void updateCatalog(int id, CatalogFormForUpdating form) {
////		Catalog entity = repository.findById(id).get();
////		entity.setName(form.getName());
////		repository.save(entity);
////	}
////
////	@Override
////	public void deleteCatalog(int id) {
////		repository.deleteById(id);
////	}
//
//
//    @Override
//    public Page<OderDetail> getByOderListId(Pageable pageable, int oderId) {
//        Page<OderDetail> oderDetails =  repository.getByOderListId(pageable, oderId);
//
//
//        List<OderDetailDTO> dtos = modelMapper.map(oderDetails.getContent(), new TypeToken<List<OderDetailDTO>>() {
//        }.getType());
//
//        Page<OderDetailDTO> dtoPages = new PageImpl<>(dtos, pageable, oderDetails.getTotalElements());
//        dtoPages.getP
//
//        return oderDetails;
//    }
//}
