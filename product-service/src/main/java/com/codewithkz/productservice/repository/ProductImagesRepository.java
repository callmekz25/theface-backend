package com.codewithkz.productservice.repository;

import com.codewithkz.productservice.model.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImagesRepository extends JpaRepository<ProductImages, String> {
}
