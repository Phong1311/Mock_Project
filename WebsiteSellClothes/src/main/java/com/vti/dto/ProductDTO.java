package com.vti.dto;

import com.vti.entity.Catalog;
import com.vti.entity.Image;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductDTO {

    @NonNull
    private int id;

    @NonNull
    private String name;

    @NonNull
    private String describe;

    @NonNull
    private String size;

    @NonNull
    private short amount;

    @NonNull
    private int price;

    @NonNull
    private int salePrice;

    @NonNull
    private LocalDateTime creatDate;

    @NonNull
    private String catalogName;

    @NonNull
    private List<ImageDTO> image;
}
