package org.pratice.praticejpa.mapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.pratice.praticejpa.dto.ProductRequest;
import org.pratice.praticejpa.dto.ProductRespone;
import org.pratice.praticejpa.model.ProductModel;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface ProductMapping {
    ProductRespone mapToProductRespone(ProductModel productModel);
    ProductModel mapToProduct(ProductRequest productRequest);
    @AfterMapping
    default void setId(@MappingTarget ProductModel productModel)
    {
        productModel.setId(0L);
    }
}
