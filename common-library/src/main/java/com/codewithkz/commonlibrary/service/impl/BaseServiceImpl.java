package com.codewithkz.commonlibrary.service.impl;

import com.codewithkz.commonlibrary.exception.NotFoundException;
import com.codewithkz.commonlibrary.model.BaseEntity;
import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.commonlibrary.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseServiceImpl<E extends BaseEntity, S, ID> implements BaseService<E, S, ID> {

    protected BaseRepository<E, ID> repository;
    protected BaseServiceImpl(BaseRepository<E, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<E> getAll() {
        return repository.findAll();
    }

    @Override
    public List<E> search(S search) {
        return repository.findAll();
    }

    @Override
    public E getById(ID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
    }

    @Override
    public E create(E entity) {
        return repository.save(entity);
    }

    @Override
    public List<E> createList(List<E> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public E update(ID id, E entity) {
        entity.setId(id.toString());
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {

    }
}
