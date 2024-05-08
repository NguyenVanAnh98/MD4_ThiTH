package com.example.md4_thith.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResDto {
    private Long id;
    private String nameProduct;
    private Double price;
    private String status;
    private Long typeProductId;
}
