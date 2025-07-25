
package com.example.similarproducts.Controller;

import com.example.similarproducts.Model.Product;
import com.example.similarproducts.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class SimilarProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<Product>> getSimilarProducts(@PathVariable String productId) {
        return ResponseEntity.ok(productService.getSimilarProducts(productId));
    }
}
