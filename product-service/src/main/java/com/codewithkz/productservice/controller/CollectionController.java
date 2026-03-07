package com.codewithkz.productservice.controller;

import com.codewithkz.commonlibrary.controller.BaseController;
import com.codewithkz.productservice.dto.collection.CollectionCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.collection.CollectionCreateUpdateResponseDTO;
import com.codewithkz.productservice.mapper.CollectionMapper;
import com.codewithkz.productservice.model.Collection;
import com.codewithkz.productservice.service.CollectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collections")
public class CollectionController extends BaseController<Collection, CollectionCreateUpdateRequestDTO, CollectionCreateUpdateResponseDTO, String, String> {
    public CollectionController(CollectionService service, CollectionMapper mapper) {
        super(service, mapper);
    }
}
