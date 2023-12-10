package nimap.com.product.management.serviceImpl;

import nimap.com.product.management.dto.ProductDTO;
import nimap.com.product.management.entity.Product;
import nimap.com.product.management.repo.ProductRepo;
import nimap.com.product.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public Page<Product> getProducts(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public Product getProductById(Long id) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + "is not found"));
        return product;
    }


    @Override
    public Product createProduct(ProductDTO productDTO) {

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        productRepo.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
         productRepo.deleteById(id);
    }
    @Override
    public void updateProduct(Long id, ProductDTO productDTO) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product for id" + id + "not found"));
        if(!productDTO.getName().isEmpty()){
            product.setName(productDTO.getName());
        }
        if(productDTO.getPrice()!=null){
            product.setPrice(productDTO.getPrice());
        }
        if(!productDTO.getDescription().isEmpty()){
            product.setDescription(productDTO.getDescription());
        }

        productRepo.save(product);
    }


}
