package com.vti.repository;

import com.vti.entity.OderDetail;
import com.vti.entity.OderList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IOderDetailRepository extends JpaRepository<OderDetail, Integer>, JpaSpecificationExecutor<OderDetail> {


    Page<OderDetail> findByOderListId(Pageable pageable, int oderId);
}
