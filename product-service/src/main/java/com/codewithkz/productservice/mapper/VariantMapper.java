package com.codewithkz.productservice.mapper;

import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.productservice.dto.attribute.AttributeCreateUpdateResponseDTO;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateResponseDTO;
import com.codewithkz.productservice.model.AttributeValue;
import com.codewithkz.productservice.model.Variant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VariantMapper extends BaseMapper<Variant, VariantCreateUpdateRequestDTO, VariantCreateUpdateResponseDTO> {
    @Override
    @Mapping(target = "attributes", source = "attributeValues")
    @Mapping(source = "default", target = "isDefault")
    @Mapping(source = "active", target = "isActive")
    VariantCreateUpdateResponseDTO toDTO(Variant entity);

    @Mapping(target = "name", source = "attribute.name")
    @Mapping(target = "value", source = "value")
    AttributeCreateUpdateResponseDTO map(AttributeValue value);

    List<AttributeCreateUpdateResponseDTO> map(List<AttributeValue> values);



}
