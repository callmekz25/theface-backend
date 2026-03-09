package com.codewithkz.productservice.repository;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.productservice.model.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VariantRepository extends BaseRepository<Variant, String> {
    @Query("SELECT v FROM Variant v JOIN FETCH v.attributeValues av LEFT JOIN FETCH av.attribute WHERE v.product.id IN :productIds")
    List<Variant> findByProductIds(List<String> productIds);
    @Query("SELECT v FROM Variant v JOIN FETCH v.attributeValues av LEFT JOIN FETCH av.attribute WHERE v.id IN :ids")
    List<Variant> findByIds(List<String> ids);
}
