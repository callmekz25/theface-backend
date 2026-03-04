package com.codewithkz.commonlibrary.controller;

import com.codewithkz.commonlibrary.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


public abstract class BaseController<Req, Res, ID extends Serializable> {

    protected BaseService<Req, Res, ID> service;

    protected BaseController(BaseService<Req, Res, ID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Res>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Res> getById(@PathVariable ID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Res> create(@RequestBody Req req) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(req));
    }

    @PutMapping
    public ResponseEntity<Res> update(@PathVariable ID id,
                                      @RequestBody Req req) {
        return ResponseEntity.ok(service.update(id, req));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
