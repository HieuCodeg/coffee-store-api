package com.hieucodeg.service.category;

import com.hieucodeg.domain.dto.category.CategoryDTO;
import com.hieucodeg.domain.entity.Category;
import com.hieucodeg.service.IGeneralService;

import java.util.List;
import java.util.Optional;


public interface ICategoryService extends IGeneralService<Category> {

    void softDelete(Long categoryId);

    List<CategoryDTO> findAllCategoryDTO();

    Optional<CategoryDTO> findCategoryDTOById(Long id);

    Boolean existsCategoryByTitle(String title);
}
