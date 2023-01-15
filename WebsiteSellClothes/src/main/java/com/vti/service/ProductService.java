package com.vti.service;

import com.vti.entity.Product;
import com.vti.form.creating.ProductFormForCreating;
import com.vti.form.updating.ProductFormForUpdating;
import com.vti.repository.IProductRepository;
import com.vti.service.implement.IProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Product getProductByID(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void createProduct(ProductFormForCreating form) {
        // omit id field
        TypeMap<ProductFormForCreating, Product> typeMap = modelMapper.getTypeMap(ProductFormForCreating.class, Product.class);
        if (typeMap == null) { // if not already added
            // skip field
            modelMapper.addMappings(new PropertyMap<ProductFormForCreating, Product>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        // convert form to entity
        Product product = modelMapper.map(form, Product.class);
//        product.setCreateDate(new Date());
        productRepository.save(product);

    }

    @Override
    public void updateProduct(int id, ProductFormForUpdating form) {
        Product entity = productRepository.findById(id).get();
        entity.setName(form.getName());
        entity.setDescribe(form.getDescribe());
        entity.setSize(form.getSize());
        entity.setAmount(form.getAmount());
        entity.setPurchasePrice(form.getPurchasePrice());
        entity.setPrice(form.getPrice());
        entity.setSalePrice(form.getSalePrice());
        productRepository.save(entity);
    }


    @Override
    public void deleteProduct(List<Integer> ids) {
        productRepository.deleteByIdIn(ids);
    }

    @Override
    public Page<Product> getAllProductByCatalogID(Pageable pageable, int catalogId) {
        return productRepository.findProductByCatalogId(pageable, catalogId);
    }

    @Override
    public List<Product> getProductByCatalogId(int catalogId) {
        return productRepository.getProductByCatalogId(catalogId);
    }

    @Override
    public List<Product> getProduct() {
        return productRepository.getProduct();
    }

    @Override
    public boolean existsProductByProductId(int id) {
        return productRepository.existsById(id);
    }

    @Override
    public boolean existsProductsByCatalogId(int catalogId) {
        return productRepository.existsProductByCatalogId(catalogId);
    }

}
