package com.vti.service.implement;

import com.vti.dto.creating.ProductFormForCreating;
import com.vti.dto.updating.ProductFormForUpdating;
import com.vti.dto.filter.ProductFilter;
import com.vti.entity.Group;
import com.vti.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

	Page<Product> getAllGroups(Pageable pageable, ProductFilter filter, String search);

	boolean isProductExistsByName(String name);

	void createProduct(ProductFormForCreating form);

	Group getProductByID(short id);

	void updateProduct(short id, ProductFormForUpdating form);

	void deleteProduct(List<Short> ids);

}
