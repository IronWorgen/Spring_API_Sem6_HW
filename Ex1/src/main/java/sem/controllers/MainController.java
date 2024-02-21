package sem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sem.model.Product;
import sem.service.iProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class MainController {
    private  final iProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return  new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return  new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return  new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}
