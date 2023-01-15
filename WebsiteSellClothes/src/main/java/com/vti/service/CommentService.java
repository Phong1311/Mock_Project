package com.vti.service;

import com.vti.entity.Comment;
import com.vti.entity.User;
import com.vti.form.creating.CommentFormForCreating;
import com.vti.repository.ICommentRepository;
import com.vti.repository.IUserRepository;
import com.vti.service.implement.ICommentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserRepository IUserRepository;

    @Override
    public Page<Comment> getCommentByProductId(Pageable pageable, int id) {
        return repository.findByProductId(pageable, id);
    }

//    @Override
//    public Comment createComment(CommentFormForCreating form) {
//
//        TypeMap<CommentFormForCreating, Comment> typeMap = modelMapper.getTypeMap(CommentFormForCreating.class, Comment.class);
//        if (typeMap == null) { // if not already added
//            // skip field
//            modelMapper.addMappings(new PropertyMap<CommentFormForCreating, Comment>() {
//                @Override
//                protected void configure() {
//                    skip(destination.getId());
//                }
//            });
//        }
//        // convert form to entity
//        Comment comment = modelMapper.map(form, Comment.class);
//
//        repository.save(comment);
//
//        Comment comment1 = repository.findCommentByContent(form.getContent());
//
//        return comment1;
//    }

    @Override
    public Comment createComment(String username, CommentFormForCreating form) {

        User user = IUserRepository.findByUsername(username);

        TypeMap<CommentFormForCreating, Comment> typeMap = modelMapper.getTypeMap(CommentFormForCreating.class, Comment.class);
        if (typeMap == null) { // if not already added
            // skip field
            modelMapper.addMappings(new PropertyMap<CommentFormForCreating, Comment>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }

        form.setUserId(user.getId());
        // convert form to entity
        Comment comment = modelMapper.map(form, Comment.class);

        repository.save(comment);

        Comment comment1 = repository.findCommentByContent(form.getContent());

        return comment1;
    }

    @Override
    public void deleteCommentByUserIdAndProductId(int userId, int productId) {
        repository.deleteCommentByUserIdAndProductId(userId, productId);
    }


}
