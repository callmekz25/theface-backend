package com.codewithkz.productservice.mapper;

import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.productservice.dto.attribute.AttributeCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.attribute.AttributeCreateUpdateResponseDTO;
import com.codewithkz.productservice.model.Attribute;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributeMapper extends BaseMapper<Attribute, AttributeCreateUpdateRequestDTO, AttributeCreateUpdateResponseDTO> {
}
