package com.example.md4_thith.service;

import com.example.md4_thith.model.TypeProduct;

import java.util.List;

public interface ITypeProductService {
    List<TypeProduct> findAll();
    void save(TypeProduct typeProduct);
    TypeProduct findById(Long id);
    void delete(Long id) throws Exception;
//    void  update(Long id, TypeProduct typeProduct) ;
}
