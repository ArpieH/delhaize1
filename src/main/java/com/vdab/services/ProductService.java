package com.vdab.services;

import com.vdab.domain.Products;
import com.vdab.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();

    public List<Products> listOfProducts() {
        return productRepository.listOfProducts();
    }
}


