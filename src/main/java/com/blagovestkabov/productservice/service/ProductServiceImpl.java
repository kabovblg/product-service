package com.blagovestkabov.productservice.service;

import com.blagovestkabov.productservice.entity.Product;
import com.blagovestkabov.productservice.exception.ProductException;
import com.blagovestkabov.productservice.model.ProductRequest;
import com.blagovestkabov.productservice.model.ProductResponse;
import com.blagovestkabov.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("adding the product ...");

        Product product = Product
                .builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("product was created !");

        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("get the product with id: {} ", productId);
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductException("product with given id not found", "PRODUCT NOT FOUND"));

        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);

        return productResponse;
    }
}
