package com.example.md4_thith.service;

import com.example.md4_thith.model.dto.ProductReqDto;
import com.example.md4_thith.model.dto.ProductResDto;

import java.util.List;

public interface IProductService {
    ProductResDto findById(Long id);
    List<ProductResDto> findAll();
    void save (ProductReqDto productReqDto);
    void delete(Long id) throws Exception;
    void  update(Long id, ProductReqDto productReqDto) ;
}
