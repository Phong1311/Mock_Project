package com.vti.service;

import com.vti.entity.OderList;
import com.vti.form.creating.OderListFormForCreating;
import com.vti.repository.ICartRepository;
import com.vti.repository.IOderListRepository;
import com.vti.repository.IPayRepository;
import com.vti.service.implement.ICartService;
import com.vti.service.implement.IOderListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OderListService implements IOderListService {

    @Autowired
    private IOderListRepository repository;

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private IPayRepository payRepository;

    @Autowired
    private ICartService cartService;

    @Autowired
    private ModelMapper modelMapper;


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
    @Override
    public void createOderList(int userId, OderListFormForCreating form) {

        int total = cartService.total(userId);

        form.setUserId(userId);

        if (form.getTotalPayment() == null) {
            form.setTotalPayment(total);
        }

        if (form.getStatus() == null) {
            form.setStatus(OderList.Status.WAITING);
        }

        OderList oderList = modelMapper.map(form, OderList.class);

        repository.save(oderList);

        cartRepository.deleteCartByUserId(userId);

        payRepository.deleteByUserId(userId);
    }
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
