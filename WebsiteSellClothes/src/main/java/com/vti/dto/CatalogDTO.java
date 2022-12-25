package com.vti.dto;

import com.vti.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CatalogDTO {

    @NonNull
    private int id;

    @NonNull
    private String name;

}
