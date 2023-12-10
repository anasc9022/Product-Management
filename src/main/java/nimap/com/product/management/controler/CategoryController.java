package nimap.com.product.management.controler;

import nimap.com.product.management.dto.CategoryDTO;
import nimap.com.product.management.entity.Category;
import nimap.com.product.management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO){

        Category category = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Category>> getCategories(@RequestParam("pageNo") int pageNo){

        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new ResponseEntity<>(categoryService.getCategories(pageable).getContent(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> updateCategoryById(@PathVariable("id") Long id,@RequestBody CategoryDTO categoryDTO){
        categoryService.updateCategoryById(id, categoryDTO);
        return new ResponseEntity<>("Update Successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCategoryById(@PathVariable("id") Long id){

        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>("Category Successfully Deleted",HttpStatus.OK);
    }
}
