package com.example.md4_thith.controller;

import com.example.md4_thith.model.dto.ProductReqDto;
import com.example.md4_thith.model.dto.ProductResDto;
import com.example.md4_thith.service.IProductService;
import com.example.md4_thith.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private TypeProductService typeProductService;


    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "") String name) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<ProductResDto> productResDtos = productService.findAll();
        modelAndView.addObject("productList", productResDtos);
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        return new ModelAndView("add")
                .addObject("ListTypeProduct", typeProductService.findAll())
                .addObject("productReqDto", new ProductResDto());


    }
    @PostMapping("/add")
    public String addProduct(ProductReqDto productReqDto) {
        productService.save(productReqDto);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) throws Exception {
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        return new ModelAndView("update")
                .addObject("productReqDto", productService.findById(id))
                .addObject("ListTypeProduct", typeProductService.findAll());
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, ProductReqDto productReqDto) {
        productService.update(id, productReqDto);
        return "redirect:/products";
    }

}
