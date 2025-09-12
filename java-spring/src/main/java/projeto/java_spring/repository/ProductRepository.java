package projeto.java_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.java_spring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
