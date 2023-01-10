package com.vti.service;

import com.vti.entity.OderDetail;
import com.vti.entity.OderDetailDBConvert;
import com.vti.entity.Product;
import com.vti.form.creating.OderDetailFormForCreating;
import com.vti.repository.*;
import com.vti.service.implement.IOderDetailService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service


@Transactional
public class OderDetailService implements IOderDetailService {

    @Autowired
    private IOderDetailRepository oderDetailRepository;

    @Autowired
    private IOderDetailConvertRepository oderDetailConvertRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICartRepository cartRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void createOderDetailByOderId(int oderId) {
        // set oderId
        List<OderDetailDBConvert> oderDetailList = oderDetailConvertRepository.getOderDetailByOderId(oderId);
        for (OderDetailDBConvert oderDetailDBConvert : oderDetailList
        ) {
            OderDetail oderDetail = new OderDetail();
            // convert form to entity
            BeanUtils.copyProperties(oderDetailDBConvert, oderDetail, "idConvert", "id");

            oderDetailRepository.save(oderDetail);
        }
    }


    @Override
    public Page<OderDetail> getOderDetailByOderId(Pageable pageable, int oderId) {
        return oderDetailRepository.findAllByOderListId(pageable, oderId);
    }
}
