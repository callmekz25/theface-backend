package com.codewithkz.productservice.repository;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends BaseRepository<Product, String> {
    Optional<Product> findBySlug(String slug);
    @Query("SELECT p FROM Product p JOIN p.collections c WHERE c.id IN :ids")
    List<Product> findByCollectionIds(List<String> ids);
}
