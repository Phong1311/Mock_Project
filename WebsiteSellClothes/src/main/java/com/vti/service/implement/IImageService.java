package com.vti.service.implement;

import com.vti.entity.Catalog;
import com.vti.entity.Image;
import com.vti.form.creating.CatalogFormForCreating;
import com.vti.form.creating.ImageFormForCreating;
import com.vti.form.updating.CatalogFormForUpdating;

import java.util.List;

public interface IImageService {

//    List<Catalog> getAllCatalogs(String search);

    Image getImageByID(int id);

    Image createImage(ImageFormForCreating form);

//    Catalog updateCatalog(int id, CatalogFormForUpdating form);
//
//    void deleteCatalog(int id);

}
