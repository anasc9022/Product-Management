package nimap.com.product.management.serviceImpl;

import nimap.com.product.management.dto.CategoryDTO;
import nimap.com.product.management.entity.Category;
import nimap.com.product.management.repo.CategoryRepo;
import nimap.com.product.management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        categoryRepo.save(category);
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Category with ID: " + id + " is not found"));
    }

    @Override
    public void updateCategoryById(Long id, CategoryDTO categoryDTO) {

        Category category = categoryRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Category with ID: " + id + " is not found"));
        if (!categoryDTO.getCategoryName().isEmpty()) {
            category.setCategoryName(categoryDTO.getCategoryName());
        }
        categoryRepo.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public Page<Category> getCategories(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }
}
