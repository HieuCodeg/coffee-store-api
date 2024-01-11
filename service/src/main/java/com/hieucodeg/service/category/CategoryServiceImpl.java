package com.hieucodeg.service.category;

import com.hieucodeg.domain.dto.category.CategoryDTO;
import com.hieucodeg.domain.entity.Category;
import com.hieucodeg.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.softDelete(id);
    }

    @Override
    public void softDelete(Long categoryId) {
        categoryRepository.softDelete(categoryId);
    }

    @Override
    public List<CategoryDTO> findAllCategoryDTO() {
        return categoryRepository.findAllCategoryDTO();
    }

    @Override
    public Optional<CategoryDTO> findCategoryDTOById(Long id) {
        return categoryRepository.findCategoryDTOById(id);
    }

    @Override
    public Boolean existsCategoryByTitle(String title) {
        return categoryRepository.existsCategoryByTitle(title);
    }
}

