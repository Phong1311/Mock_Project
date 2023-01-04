package com.vti.controller;

import com.vti.dto.CatalogDTO;
import com.vti.dto.OderListDTO;
import com.vti.entity.Catalog;
import com.vti.entity.OderList;
import com.vti.form.creating.CatalogFormForCreating;
import com.vti.form.updating.CatalogFormForUpdating;
import com.vti.service.implement.ICatalogService;
import com.vti.service.implement.IOderListService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/oderLists")
public class OderListController {

    @Autowired
    private IOderListService service;

    @Autowired
    private ModelMapper modelMapper;

//    @GetMapping()
//    public ResponseEntity<?> getAllCatalogs(Pageable pageable, @RequestParam(name = "search", required = false) String search) {
//        Page<Catalog> entities = service.getAllCatalogs(pageable, search);
//
//        // convert entities --> dtos
//        List<CatalogDTO> dtos = modelMapper.map(entities.getContent(), new TypeToken<List<CatalogDTO>>() {
//        }.getType());
//
//        Page<CatalogDTO> dtoPages = new PageImpl<>(dtos, pageable, entities.getTotalElements());
//
//        return new ResponseEntity<>(dtoPages, HttpStatus.OK);
//    }


    @GetMapping(value = "/oderList")
    public ResponseEntity<?> getOderListByUsername(Pageable pageable) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        Page<OderList> oderLists = service.getOderListByUsername(pageable, userDetails.getUsername());

        List<OderListDTO> dtos = modelMapper.map(oderLists.getContent(), new TypeToken<List<OderListDTO>>() {
        }.getType());

        Page<OderListDTO> dtoPages = new PageImpl<>(dtos, pageable, oderLists.getTotalElements());

        return new ResponseEntity<>(dtoPages, HttpStatus.OK);
    }

//    @PostMapping()
//    public ResponseEntity<?> createCatalog(@RequestBody CatalogFormForCreating form) {
//        service.createCatalog(form);
//        return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
//    }
//
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<?> updateCatalog(@PathVariable(name = "id") short id, @RequestBody CatalogFormForUpdating form) {
//        service.updateCatalog(id, form);
//        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
//    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteCatalog(@PathVariable(name = "id") int id) {
//        service.deleteCatalog(id);
//        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
//    }
}
