package com.codewithkz.productservice.mapper;

import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.productservice.dto.attributevalue.AttributeValueCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.attributevalue.AttributeValueCreateUpdateResponseDTO;
import com.codewithkz.productservice.model.AttributeValue;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributeValueMapper extends BaseMapper<AttributeValue, AttributeValueCreateUpdateRequestDTO, AttributeValueCreateUpdateResponseDTO> {
}
