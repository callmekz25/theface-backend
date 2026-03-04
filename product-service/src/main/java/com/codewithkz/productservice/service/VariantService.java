package com.codewithkz.productservice.service;

import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.variant.VariantDTO;
import com.codewithkz.productservice.model.Product;
import com.codewithkz.productservice.model.Variant;

import java.util.List;

public interface VariantService extends BaseService<Variant, VariantCreateUpdateRequestDTO, String> {
    List<Variant> createList(Product product, List<VariantDTO> variants);
}
