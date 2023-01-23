package com.vti.service.implement;

import com.vti.entity.Product;
import com.vti.form.creating.ProductFormForCreating;
import com.vti.form.updating.ProductFormForUpdating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {


    Product getProductByID(int id);

    Product createProduct(ProductFormForCreating form);

    void updateProduct(int id, ProductFormForUpdating form);

    void deleteProduct(List<Integer> ids);

    Page<Product> getAllProductByCatalogID(Pageable pageable, int catalogId);

    List<Product> getProductByCatalogId(int catalogId);

    List<Product> getProduct();

    boolean existsProductByProductId(int id);

    boolean existsProductsByCatalogId(int catalogId);
}
