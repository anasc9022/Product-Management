package nimap.com.product.management.service;

import nimap.com.product.management.dto.CategoryDTO;
import nimap.com.product.management.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Category createCategory(CategoryDTO categoryDTO);

    Category getCategoryById(Long id);

    void updateCategoryById(Long id, CategoryDTO categoryDTO);

    void deleteCategoryById(Long id);

    Page<Category> getCategories(Pageable pageable);
}
