package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String review;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;

    @NonNull
    private String catalogName;

    @NonNull
    private List<ImageDTO> image;

    @Data
    @NoArgsConstructor
    static class ImageDTO {

        @JsonProperty("imageId")
        private int id;

        private String imageUrl;

    }
}
