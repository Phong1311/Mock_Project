package com.vti.controller;

import com.vti.dto.CartDTO;
import com.vti.dto.CatalogDTO;
import com.vti.dto.CommentDTO;
import com.vti.entity.Cart;
import com.vti.entity.Catalog;
import com.vti.entity.Comment;
import com.vti.form.creating.CatalogFormForCreating;
import com.vti.form.creating.CommentFormForCreating;
import com.vti.form.updating.CatalogFormForUpdating;
import com.vti.service.implement.ICatalogService;
import com.vti.service.implement.ICommentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/comments")
public class CommentController {

    @Autowired
    private ICommentService service;

    @Autowired
    private ModelMapper modelMapper;




    @GetMapping(value = "/productId/{productId}")
    public ResponseEntity<?> getCommentByProductId(Pageable pageable, @PathVariable(name = "productId") int productId) {

        Page<Comment> comments = service.getCommentByProductId(pageable, productId);

        // convert entities --> dtos
        List<CommentDTO> dtos = modelMapper.map(comments.getContent(), new TypeToken<List<CommentDTO>>() {
        }.getType());

        Page<CommentDTO> dtoPages = new PageImpl<>(dtos, pageable, comments.getTotalElements());

        return new ResponseEntity<>(dtoPages, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createCatalog(@RequestBody CommentFormForCreating form) {
        service.createComment(form);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable(name = "id") int id) {
        service.deleteComment(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }
}
