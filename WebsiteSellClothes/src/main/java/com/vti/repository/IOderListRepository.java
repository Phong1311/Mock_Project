package com.vti.repository;

import com.vti.entity.OderList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IOderListRepository extends JpaRepository<OderList, Integer>, JpaSpecificationExecutor<OderList> {

    Page<OderList> findByUserUsername(Pageable pageable, String username);

    Page<OderList> findByUserUsernameAndStatus(Pageable pageable, String username, OderList.Status status);

}
