package com.codewithkz.productservice.repository;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.productservice.model.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends BaseRepository<Collection, String> {
    @Query("SELECT c FROM Collection c WHERE c.id IN :ids")
    List<Collection> findByIds(List<String> ids);
}
