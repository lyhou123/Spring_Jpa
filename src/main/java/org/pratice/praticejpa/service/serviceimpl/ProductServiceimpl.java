package org.pratice.praticejpa.service.serviceimpl;
import lombok.RequiredArgsConstructor;
import org.pratice.praticejpa.dto.ProductRequest;
import org.pratice.praticejpa.dto.ProductRespone;
import org.pratice.praticejpa.mapper.ProductMapping;
import org.pratice.praticejpa.model.ProductModel;
import org.pratice.praticejpa.repository.ProductRepository;
import org.pratice.praticejpa.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceimpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapping productMapping;
    private ProductModel findyById(Long id)
    {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
    }
    @Override
    public List< ProductRespone > getAllProducts() {
      return productRepository.findAll()
              .stream().map(productMapping::mapToProductRespone).toList();
    }
    @Override
    public ProductRespone createProduct(ProductRequest productRequest) {
     var newProduct=productMapping.mapToProduct(productRequest);
     return productMapping.mapToProductRespone(productRepository.save(newProduct));
    }

    @Override
    public ProductRespone updateProduct( Long id, ProductRequest productRequest) {
        var newProduct=findyById(id);
        newProduct=productMapping.mapToProduct(productRequest);
        newProduct.setId(id);
        return productMapping.mapToProductRespone(productRepository.save(newProduct));
    }

    @Override
    public ProductRespone getProductById(Long id) {
       var newProduct=findyById(id);
       return productMapping.mapToProductRespone(newProduct);
    }

    @Override
    public ProductRespone deleteProduct(Long id) {
        var newProduct=findyById(id);
        productRepository.delete(newProduct);
        return productMapping.mapToProductRespone(newProduct);
    }
}
