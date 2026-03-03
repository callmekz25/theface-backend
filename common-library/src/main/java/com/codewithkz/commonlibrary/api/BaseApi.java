package com.codewithkz.commonlibrary.api;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

public interface BaseApi<Req extends BaseDTO, Res extends BaseDTO, ID extends Serializable> {
    ResponseEntity<List<Res>> getAll();
    ResponseEntity<Res> getById(@PathVariable ID id);
    ResponseEntity<Res> create(@RequestBody Req req);
    ResponseEntity<Res> update(@PathVariable ID id, @RequestBody Req req);
    ResponseEntity delete(@PathVariable ID id);

}
