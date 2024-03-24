package org.pratice.praticejpa.service;

import org.pratice.praticejpa.dto.ProductRequest;
import org.pratice.praticejpa.dto.ProductRespone;
import org.pratice.praticejpa.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductRespone> getAllProducts();
    ProductRespone createProduct(ProductRequest productRequest);
    ProductRespone updateProduct(Long id,ProductRequest productRequest);
    ProductRespone getProductById(Long id);
    ProductRespone deleteProduct(Long id);
}
