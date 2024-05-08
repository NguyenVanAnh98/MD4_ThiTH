package com.example.md4_thith.service;

import com.example.md4_thith.model.TypeProduct;
import com.example.md4_thith.repo.ITypeProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeProductService implements ITypeProductService {
    private final ITypeProductRepository typeProductRepository;

    @Override
    public List<TypeProduct> findAll() {
        List<TypeProduct> typeProducts = typeProductRepository.findAll();
        return typeProducts;
    }

    @Override
    public void save(TypeProduct typeProduct) {typeProductRepository.save(typeProduct);

    }

    @Override
    public TypeProduct findById(Long id) {
     return typeProductRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            typeProductRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
