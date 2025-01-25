package com.semicolon.farm_Links.controller;

import com.semicolon.farm_Links.data.model.Product;
import com.semicolon.farm_Links.data.model.ProductCategory;
import com.semicolon.farm_Links.dto.request.AddProductRequest;
import com.semicolon.farm_Links.dto.request.UpdateProductRequest;
import com.semicolon.farm_Links.dto.request.DeleteProductRequest;
import com.semicolon.farm_Links.dto.response.AddProductResponse;
import com.semicolon.farm_Links.dto.response.UpdateProductResponse;
import com.semicolon.farm_Links.dto.response.DeleteProductResponse;
import com.semicolon.farm_Links.dto.response.ApiResponse;
import com.semicolon.farm_Links.exception.FarmLinkException;
import com.semicolon.farm_Links.service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@NonNull
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest request) {
        try {
            AddProductResponse result = productService.addProduct(request);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(new ApiResponse(true, products));
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable ProductCategory category) {
        try {
            List<Product> products = productService.getProductsByCategory(category);
            return ResponseEntity.ok(new ApiResponse(true, products));
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.getProductById(id)
                    .orElseThrow(() -> new FarmLinkException("Product not found with ID: " + id));
            return ResponseEntity.ok(new ApiResponse(true, product));
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody UpdateProductRequest request) {
        try {
            UpdateProductResponse result = productService.updateProduct(request);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestBody DeleteProductRequest request) {
        try {
            DeleteProductResponse result = productService.deleteProduct(request);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }
}

