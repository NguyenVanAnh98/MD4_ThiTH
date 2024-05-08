package com.example.md4_thith.service;

import com.example.md4_thith.model.Product;
import com.example.md4_thith.model.dto.ProductReqDto;
import com.example.md4_thith.model.dto.ProductResDto;
import com.example.md4_thith.repo.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService  implements IProductService{
    private final IProductRepository productRepository;
    private final ITypeProductService typeProductService;


    @Override
    public ProductResDto findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductResDto productResDto = new ProductResDto();
        productResDto.setId(product.getId());
        productResDto.setNameProduct(product.getName());
        productResDto.setPrice(product.getPrice());
        productResDto.setStatus(product.getStatus());
        productResDto.setTypeProductId(product.getTypeProduct().getId());
        return productResDto;
    }

    @Override
    public List<ProductResDto> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductResDto> productResDtos = new ArrayList<>();

        for (Product product : products) {
            ProductResDto productResDto = new ProductResDto();
            productResDto.setId(product.getId());
            productResDto.setNameProduct(product.getName());
            productResDto.setPrice(product.getPrice());
            productResDto.setStatus(product.getStatus());
            productResDto.setTypeProductId(product.getTypeProduct().getId());
            productResDtos.add(productResDto);
        }

        return productResDtos;
    }

    @Override
    public void save(ProductReqDto productReqDto) {
        Product product = new Product();
        product.setName(productReqDto.getNameProduct());
        product.setPrice(productReqDto.getPrice());
        product.setStatus(productReqDto.getStatus());
        product.setTypeProduct(typeProductService.findById(productReqDto.getTypeProductId()));
        productRepository.save(product);

    }

    @Override
    public void delete(Long id) throws Exception {
        productRepository.deleteById(id);

    }

    @Override
    public void update(Long id, ProductReqDto productReqDto) {
        Product product = productRepository.findById(id).orElse(null);
        product.setName(productReqDto.getNameProduct());
        product.setPrice(productReqDto.getPrice());
        product.setStatus(productReqDto.getStatus());
        product.setTypeProduct(typeProductService.findById(productReqDto.getTypeProductId()));
        productRepository.save(product);

    }
}
