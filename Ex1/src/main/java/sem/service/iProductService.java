package sem.service;

import org.springframework.stereotype.Service;
import sem.model.Product;

import java.util.List;

public interface iProductService {
    List<Product> getProducts();
    Product getProductById(Long id);
    Product updateProduct(Product product);
    Product createProduct(Product product);
    void deleteProductById(Long id);
}
