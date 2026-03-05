package com.codewithkz.productservice.mapper;

import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.productservice.dto.productimage.ProductImageCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.productimage.ProductImageCreateUpdateResponseDTO;
import com.codewithkz.productservice.model.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductImageMapper extends BaseMapper<ProductImage, ProductImageCreateUpdateRequestDTO, ProductImageCreateUpdateResponseDTO> {
}
