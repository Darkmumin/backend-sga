package com.jai.darkmumin.sga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jai.darkmumin.sga.models.Category;
import com.jai.darkmumin.sga.services.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    ResponseEntity <List<Category>> getCategory() {
        return new ResponseEntity<>(categoryService.getCategory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity <Category> obtainCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.obtainCategoryById(id), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity <Category> saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity <Category> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    ResponseEntity <Category> updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
