package com.EcommerceApplication.Service;


import com.EcommerceApplication.Dto.ProductDTO;
import com.EcommerceApplication.Entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);
    List<Product> getAllProducts();
}
