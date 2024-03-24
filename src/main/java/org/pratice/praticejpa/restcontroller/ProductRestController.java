package org.pratice.praticejpa.restcontroller;
import lombok.RequiredArgsConstructor;
import org.pratice.praticejpa.dto.ProductRequest;
import org.pratice.praticejpa.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;
    private Map<String,Object> respone(Object data,String message,int status)
    {
        Map<String,Object> response=new HashMap<>();
        response.put("data",data);
        response.put("message",message);
        response.put("status",status);
        return response;
    }
    @GetMapping
    public Map<String,Object> getAllProduct()
    {
        return respone(productService.getAllProducts(),"All Products", HttpStatus.OK.value());
    }
    @PostMapping
    public Map<String,Object> createProduct(ProductRequest productRequest)
    {
        return respone(productService.createProduct(productRequest),"Product Created",HttpStatus.CREATED.value());
    }
    @PutMapping("/{id}")
    public Map<String,Object> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest)
    {
        return respone(productService.updateProduct(id,productRequest),"Product Updated",HttpStatus.OK.value());
    }
    @DeleteMapping("/{id}")
    public Map<String,Object> deleteProduct(@PathVariable Long id)
    {
        return respone(productService.deleteProduct(id),"Product Deleted",HttpStatus.OK.value());
    }
   @GetMapping("/{id}")
    public Map<String,Object> getProductById(@PathVariable Long id)
    {
        return respone(productService.getProductById(id),"Product",HttpStatus.OK.value());
    }
}
