package projeto.java_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.java_spring.model.Product;
import projeto.java_spring.repository.ProductRepository;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> productList(){
        return productRepository.findAll();
    }

    @PostMapping
    public ResponseEntity <Product> save (@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }


}
