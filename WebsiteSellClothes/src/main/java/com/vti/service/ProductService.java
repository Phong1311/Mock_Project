package com.vti.service;

import com.vti.entity.Image;
import com.vti.entity.Product;
import com.vti.entity.User;
import com.vti.form.creating.ProductFormForCreating;
import com.vti.form.updating.ProductFormForUpdating;
import com.vti.repository.IImageRepository;
import com.vti.repository.IProductRepository;
import com.vti.repository.IUserRepository;
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

    @Autowired
    private IImageRepository imageRepository;

    @Autowired
    private com.vti.repository.IUserRepository IUserRepository;


    @Override
    public Product getProductByID(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product createProduct(String username, ProductFormForCreating form) {

        User user = IUserRepository.findByUsername(username);

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

        if (form.getImage() != null) {
            // create image
            Image image = new Image();
            image.setImage1(form.getImage().getImage1());
            image.setImage2(form.getImage().getImage2());
            image.setImage3(form.getImage().getImage3());
            image.setImage4(form.getImage().getImage4());
            image.setImage5(form.getImage().getImage5());
            image.setImage6(form.getImage().getImage6());

            Image saveImage = imageRepository.save(image);

            // create product
            product.setImage(saveImage);
        }
        Product returnProduct = productRepository.save(product);
        Product returnProduct1 = productRepository.findById(returnProduct.getId()).get();
        return returnProduct1;
    }

    @Override
    public Product updateProduct(int id, ProductFormForUpdating form) {
        Product entity = productRepository.findById(id).get();
        entity.setName(form.getName());
        entity.setDescribe(form.getDescribe());
        entity.setSize(form.getSize());
        entity.setAmount(form.getAmount());
        entity.setPurchasePrice(form.getPurchasePrice());
        entity.setPrice(form.getPrice());
        entity.setSalePrice(form.getSalePrice());
        Product returnProduct = productRepository.save(entity);
        return returnProduct;
    }


    @Override
    public void deleteProducts(List<Integer> ids) {
        productRepository.deleteByIdIn(ids);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
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
