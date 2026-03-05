package com.codewithkz.productservice.repository;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.productservice.model.ProductImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends BaseRepository<ProductImage, String> {
    @Query("SELECT pi FROM ProductImage pi WHERE pi.variant.id IN :variantIds")
    List<ProductImage> findByVariantIds(List<String> variantIds);
}
