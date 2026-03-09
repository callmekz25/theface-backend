package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.productservice.model.Collection;
import com.codewithkz.productservice.repository.CollectionRepository;
import com.codewithkz.productservice.service.CollectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl extends BaseServiceImpl<Collection, String, String> implements CollectionService {
   private final CollectionRepository repository;

   public CollectionServiceImpl(CollectionRepository repository) {
       super(repository);
       this.repository = repository;
   }

    @Override
    public List<Collection> getByIds(List<String> ids) {
        return repository.findByIds(ids);
    }

    @Override
    public List<Collection> getBySlugs(List<String> slugs) {
        return repository.findBySlugs(slugs);
    }
}
