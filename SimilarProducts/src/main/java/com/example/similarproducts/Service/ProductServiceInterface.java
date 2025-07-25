package com.example.similarproducts.Service;

import com.example.similarproducts.Model.Product;

import java.util.List;

public interface ProductServiceInterface {
     List<Product> getSimilarProducts(final String productId);
}
