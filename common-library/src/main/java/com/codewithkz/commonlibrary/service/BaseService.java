package com.codewithkz.commonlibrary.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<Req, Res, ID> {
    List<Res> getAll();
    Res getById(ID id);
    Res create(Req request);
    Res update(ID id, Req request);
    void delete(ID id);
}
