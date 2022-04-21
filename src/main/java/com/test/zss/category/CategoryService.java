package com.test.zss.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId);
    }

    public void saveCategory(Category category) {
        Optional<Category> exists = this.categoryRepository.findCategoryByTitle(category.getTitle());
        if (exists.isPresent()) {
            throw new IllegalStateException("Category "+ category.getTitle() + " already exists");
        }
        this.categoryRepository.save(category);
    }

    public void editCategory(Long categoryId, Category category) {
        Optional<Category> exists = this.categoryRepository.findById(categoryId);
        if (exists.isEmpty()) {
            throw new IllegalStateException("Category does not exist");
        }

        Category editedCategory = exists.get();
        editedCategory.setTitle(category.getTitle());
        this.categoryRepository.save(editedCategory);
    }

    public void deleteCategory(Long id) {
        Optional<Category> exists = this.categoryRepository.findById(id);
        if (exists.isEmpty()) {
            throw new IllegalStateException("Category does not exist");
        }
        this.categoryRepository.deleteById(id);
    }
}
