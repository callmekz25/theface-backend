package com.codewithkz.commonlibrary.controller;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.commonlibrary.model.BaseEntity;
import com.codewithkz.commonlibrary.service.BaseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseController<E extends BaseEntity, Req extends BaseDTO, Res extends BaseDTO, S, ID> {

    protected BaseService<E, S, ID> service;
    protected BaseMapper<E, Req, Res> mapper;


    @GetMapping
    public ResponseEntity<List<Res>> getAll(@ModelAttribute S search) {
        List<E> result = service.getAll(search);
        return ResponseEntity.ok(mapper.toDTOList(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Res> getById(@PathVariable("id") ID id) {
        E entity = service.getById(id);
        return ResponseEntity.ok(mapper.toDTO(entity));
    }

    @PostMapping
    public ResponseEntity<Res> create(@RequestBody Req req) {
        E entity = mapper.toEntity(req);
        E created = service.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDTO(created));
    }

    @PutMapping
    public ResponseEntity<Res> update(@PathVariable("id") ID id,
                                      @RequestBody Req req) {
        E entity = mapper.toEntity(req);
        E updated = service.update(id, entity);
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("id") ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
