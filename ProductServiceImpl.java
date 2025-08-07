package com.EcommerceApplication.Service.Impl;


import com.EcommerceApplication.Dto.ProductDTO;
import com.EcommerceApplication.Entity.Product;
import com.EcommerceApplication.Repository.ProductRepository;
import com.EcommerceApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDTO productDTO) {
    	System.out.println("Received: " + productDTO.getName() + ", " + productDTO.getPrice());

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
