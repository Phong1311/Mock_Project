package com.vti.service.implement;

import com.vti.entity.Comment;
import com.vti.form.creating.CommentFormForCreating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommentService {


    Page<Comment> getCommentByProductId(Pageable pageable,int productId);

    Comment createComment(CommentFormForCreating form);


    void deleteCommentByUserIdAndProductId(int userId, int productId);

}
