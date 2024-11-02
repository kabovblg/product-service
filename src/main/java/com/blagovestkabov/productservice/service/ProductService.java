package com.blagovestkabov.productservice.service;

import com.blagovestkabov.productservice.model.ProductRequest;
import com.blagovestkabov.productservice.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
