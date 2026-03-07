package com.codewithkz.productservice.repository;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.productservice.model.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends BaseRepository<Brand, String> {
}
