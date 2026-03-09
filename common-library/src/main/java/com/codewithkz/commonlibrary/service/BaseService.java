package com.codewithkz.commonlibrary.service;

import com.codewithkz.commonlibrary.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity, S, ID> {
    List<E> getAll(S request);
    E getById(ID id);
    E create(E entity);
    List<E> search(S request);
    List<E> createList(List<E> entities);
    E update(ID id, E entity);
    void delete(ID id);
}
