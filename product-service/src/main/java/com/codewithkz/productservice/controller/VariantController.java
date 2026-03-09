package com.codewithkz.productservice.controller;

import com.codewithkz.commonlibrary.controller.BaseController;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateResponseDTO;
import com.codewithkz.productservice.dto.variant.VariantSearchRequestDTO;
import com.codewithkz.productservice.mapper.VariantMapper;
import com.codewithkz.productservice.model.Variant;
import com.codewithkz.productservice.service.VariantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/variants")
public class VariantController extends BaseController<Variant, VariantCreateUpdateRequestDTO, VariantCreateUpdateResponseDTO, VariantSearchRequestDTO, String> {
    private final VariantService service;
    private final VariantMapper mapper;
    public VariantController(VariantService service, VariantMapper mapper) {
        super(service, mapper);
        this.service = service;
        this.mapper = mapper;
    }

}
