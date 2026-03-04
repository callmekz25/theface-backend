package com.codewithkz.productservice.mapper;

import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateResponseDTO;
import com.codewithkz.productservice.model.Variant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VariantMapper extends BaseMapper<Variant, VariantCreateUpdateRequestDTO, VariantCreateUpdateResponseDTO> {
}
