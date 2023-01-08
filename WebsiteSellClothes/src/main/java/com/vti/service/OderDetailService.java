package com.vti.service;

import com.vti.dto.CartDTO;
import com.vti.dto.oderDetail.OderDetailDTO;
import com.vti.dto.oderDetail.ProductDTO;
import com.vti.entity.Cart;
import com.vti.entity.Comment;
import com.vti.entity.OderDetail;
import com.vti.entity.Product;
import com.vti.form.creating.CartFormForCreating;
import com.vti.form.creating.OderDetailFormForCreating;
import com.vti.repository.ICartRepository;
import com.vti.repository.IOderDetailRepository;
import com.vti.repository.IProductRepository;
import com.vti.repository.IUserRepository;
import com.vti.service.implement.IOderDetailService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
    private IProductRepository productRepository;

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Page<OderDetail> getOderDetailByOderId(Pageable pageable, int oderId) {

// set oderId
        OderDetailFormForCreating oderDetailFormForCreating = new OderDetailFormForCreating();
        oderDetailFormForCreating.setOderListId(oderId);

        // set productName and salePrice
        List<Product> products = productRepository.getNameAndPriceByOderId(oderId);

        for (Product form: products) {

            oderDetailFormForCreating.setProductName(form.getName());
            oderDetailFormForCreating.setPrice(form.getPrice());
        }

        // set Quantity
        List<Integer> quantityByOderId = cartRepository.getQuantityByOderId(oderId);
        for (Integer integer : quantityByOderId){
            oderDetailFormForCreating.setQuantity(integer);
        }

        // set Total
        List<Integer> totalByOderId = oderDetailRepository.getTotalByOderId(oderId);
        for (Integer integer : totalByOderId){
            oderDetailFormForCreating.setTotal(integer);

        }

        // omit id field
        TypeMap<OderDetailFormForCreating, OderDetail> typeMap = modelMapper.getTypeMap(OderDetailFormForCreating.class, OderDetail.class);
        if (typeMap == null) { // if not already added
            // skip field
            modelMapper.addMappings(new PropertyMap<OderDetailFormForCreating, OderDetail>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        // convert form to entity
        OderDetail oderDetail = modelMapper.map(oderDetailFormForCreating, OderDetail.class);

        oderDetailRepository.save(oderDetail);

        return oderDetailRepository.findAllByOderListId(pageable,oderId);
    }
}
