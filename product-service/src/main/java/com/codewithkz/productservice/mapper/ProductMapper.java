package com.codewithkz.productservice.mapper;

import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateResponseDTO;
import com.codewithkz.productservice.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {VariantMapper.class})
public interface ProductMapper extends BaseMapper<Product, ProductCreateUpdateRequestDTO, ProductCreateUpdateResponseDTO> {
}
