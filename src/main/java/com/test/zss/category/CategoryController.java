package com.test.zss.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return this.categoryService.getAllCategories();
    }

    @GetMapping(path = "{categoryId}")
    public Optional<Category> getCategory(@PathVariable("categoryId") Long categoryId) {
        return this.categoryService.getCategory(categoryId);
    }

    @PostMapping
    public void saveCategory(@RequestBody Category category) {
        this.categoryService.saveCategory(category);
    }

    @PatchMapping(path = "{categoryId}")
    public void editCategory(@PathVariable ("categoryId") Long categoryId, @RequestBody Category category) {
        this.categoryService.editCategory(categoryId, category);
    }

    @DeleteMapping(path = "{categoryId}")
    public void deleteCategory(@PathVariable ("categoryId") Long categoryId) {
        this.categoryService.deleteCategory(categoryId);
    }
}
