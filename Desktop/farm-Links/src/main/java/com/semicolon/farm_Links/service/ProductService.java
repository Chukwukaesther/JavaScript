package com.semicolon.farm_Links.service;

import com.semicolon.farm_Links.data.model.Product;
import com.semicolon.farm_Links.data.model.ProductCategory;
import com.semicolon.farm_Links.dto.request.AddProductRequest;
import com.semicolon.farm_Links.dto.request.DeleteProductRequest;
import com.semicolon.farm_Links.dto.request.UpdateProductRequest;
import com.semicolon.farm_Links.dto.response.AddProductResponse;
import com.semicolon.farm_Links.dto.response.DeleteProductResponse;
import com.semicolon.farm_Links.dto.response.UpdateProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    AddProductResponse addProduct(AddProductRequest product);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(ProductCategory category);
    Optional<Product> getProductById(Long productId);
    UpdateProductResponse updateProduct(UpdateProductRequest updatedProduct);
    DeleteProductResponse deleteProduct(DeleteProductRequest request);
}
