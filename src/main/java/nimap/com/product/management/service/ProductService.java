package nimap.com.product.management.service;

import nimap.com.product.management.dto.ProductDTO;
import nimap.com.product.management.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);

    Page<Product> getProducts(Pageable pageable);

    Product getProductById(Long id);

    void deleteProduct(Long id);

    void updateProduct(Long id, ProductDTO productDTO);
}
