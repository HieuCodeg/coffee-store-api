package com.hieucodeg.repository;

import com.hieucodeg.domain.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {

    Optional<ProductImage> findById(String id);
}