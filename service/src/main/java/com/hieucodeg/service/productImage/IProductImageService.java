package com.hieucodeg.service.productImage;

import com.hieucodeg.domain.entity.ProductImage;
import com.hieucodeg.service.IGeneralService;

import java.util.Optional;


public interface IProductImageService extends IGeneralService<ProductImage> {

    Optional<ProductImage> findById(String id);

    void delete(String id);
}

