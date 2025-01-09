package com.jai.darkmumin.sga.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jai.darkmumin.sga.models.Category;
import com.jai.darkmumin.sga.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    // Is the method service CRUD for Category
    public Page<Category> getCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
    public Category obtainCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
