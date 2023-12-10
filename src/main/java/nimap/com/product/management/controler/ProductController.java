package nimap.com.product.management.controler;

import nimap.com.product.management.dto.ProductDTO;
import nimap.com.product.management.entity.Product;
import nimap.com.product.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> getProducts(@RequestParam("pageNo") int pageNo) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        List<Product> products = productService.getProducts(pageable).getContent();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {

        productService.createProduct(productDTO);
        return new ResponseEntity<>("Saved Successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    void updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {

        productService.deleteProduct(id);
        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
    }


}
