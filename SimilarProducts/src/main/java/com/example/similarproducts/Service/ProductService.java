
package com.example.similarproducts.Service;

import com.example.similarproducts.Model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface{
    @Value("${external.api.base-url}")
    private String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Product> getSimilarProducts(final String productId) {

        final String[] similarIds = restTemplate.getForObject(baseUrl + productId + "/similarids", String[].class);
        final List<Product> products = new ArrayList<>();
        if (similarIds != null) {
            for (String id : similarIds) {
                try {
                   final Product product = restTemplate.getForObject(baseUrl + id, Product.class);
                    if (product != null) {
                        products.add(product);
                    }
                } catch (final Exception e) {
                    // Ignore missing products
                }
            }
        }
        return products;
    }
}
