package com.codewithkz.productservice.service;

import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.productservice.model.Collection;

import java.util.List;

public interface CollectionService extends BaseService<Collection, String, String> {
    List<Collection> getByIds(List<String> ids);
    List<Collection> getBySlugs(List<String> slugs);
}
