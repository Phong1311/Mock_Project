package com.vti.repository;

import com.vti.entity.OderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOderDetailRepository extends JpaRepository<OderDetail, Integer>, JpaSpecificationExecutor<OderDetail> {


    Page<OderDetail> findAllByOderListId(Pageable pageable, int oderId);
}