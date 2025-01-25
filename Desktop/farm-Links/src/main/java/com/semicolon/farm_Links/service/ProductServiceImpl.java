package com.semicolon.farm_Links.service;

import com.semicolon.farm_Links.data.model.Product;
import com.semicolon.farm_Links.data.model.ProductCategory;
import com.semicolon.farm_Links.data.repository.ProductRepository;
import com.semicolon.farm_Links.dto.request.AddProductRequest;
import com.semicolon.farm_Links.dto.request.DeleteProductRequest;
import com.semicolon.farm_Links.dto.request.UpdateProductRequest;
import com.semicolon.farm_Links.dto.response.AddProductResponse;
import com.semicolon.farm_Links.dto.response.DeleteProductResponse;
import com.semicolon.farm_Links.dto.response.UpdateProductResponse;
import com.semicolon.farm_Links.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    public AddProductResponse addProduct(AddProductRequest request) {

        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        product = productRepository.save(product);

        AddProductResponse response = new AddProductResponse();
        BeanUtils.copyProperties(product, response);
        response.setMessage("Product added successfully");
        return response;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(ProductCategory category) {
        return productRepository.findByCategory(category.name());
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("UpdateProductRequest cannot be null");
        }
        if (request.getProductId() == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }

        Product existingProduct = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + request.getProductId()));

        existingProduct.setName(request.getName());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setDescription(request.getDescription());
        Product updatedProduct = productRepository.save(existingProduct);

        UpdateProductResponse response = new UpdateProductResponse();
        response.setMessage("Product updated successfully");
        response.setProductId(updatedProduct.getId());
        response.setUpdatedName(updatedProduct.getName());
        return response;
    }

    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest request) {
        Optional<Product> existingProductOpt = productRepository.findById(request.getProductId());
        if (existingProductOpt.isPresent()) {
            productRepository.delete(existingProductOpt.get());

            DeleteProductResponse response = new DeleteProductResponse();
            response.setMessage("Product deleted successfully");
            return response;
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }
}
