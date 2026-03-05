package com.codewithkz.productservice.repository;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.productservice.model.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeValueRepository extends BaseRepository<AttributeValue, String> {
}
