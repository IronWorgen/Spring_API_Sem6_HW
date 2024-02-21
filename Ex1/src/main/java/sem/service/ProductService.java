package sem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sem.model.Product;
import sem.repository.ProductRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService implements iProductService{
    private final ProductRepository productRepo;
    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productById = getProductById(product.getId());

        /*productById.setCount(product.getCount());*/
        productById.setName(product.getName());
        productById.setQuantity(product.getQuantity());


        return productRepo.save(productById);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Product productById = getProductById(id);
        productRepo.delete(productById);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
