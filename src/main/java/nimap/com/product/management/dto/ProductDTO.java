package nimap.com.product.management.dto;

import lombok.Getter;
import lombok.Setter;
import nimap.com.product.management.entity.Category;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String name;
    private Double price;
    private String description;
    private Category category;
}
