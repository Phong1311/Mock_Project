package com.vti.controller;

import com.vti.dto.OderListDTO;
import com.vti.dto.oderDetail.OderDetailDTO;
import com.vti.entity.OderDetail;
import com.vti.entity.OderList;
import com.vti.form.creating.OderListFormForCreating;
import com.vti.service.implement.IOderDetailService;
import com.vti.service.implement.IOderListService;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping(value = "/api/v1/oderDetails")
public class OderDetailController {

    @Autowired
    private IOderDetailService service;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping()
    public ResponseEntity<?> getOderDetailByOderId(Pageable pageable, @Parameter(name = "oderId") int oderId) {

        Page<OderDetail> oderDetails = service.getOderDetailByOderId(pageable, oderId);

        // convert entities --> dtos
        List<OderDetailDTO> dtos = modelMapper.map(oderDetails.getContent(), new TypeToken<List<OderDetailDTO>>() {
        }.getType());

        Page<OderDetailDTO> dtoPages = new PageImpl<>(dtos, pageable, oderDetails.getTotalElements());

        return new ResponseEntity<>(dtoPages, HttpStatus.OK);
    }


}
