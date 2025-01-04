package com.jai.darkmumin.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jai.darkmumin.sga.models.Category;
import com.jai.darkmumin.sga.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository CategoryRepository;
    public List<Category> getCategory() {
        return CategoryRepository.findAll();
    }
    public Category obtainCategoryById(Long id) {
        return CategoryRepository.findById(id).get();
    }
    public Category saveCategory(Category category) {
        return CategoryRepository.save(category);
    }
    public void deleteCategory(Long id) {
        CategoryRepository.deleteById(id);
    }
    public Category updateCategory(Category category) {
        return CategoryRepository.save(category);
    }

}
